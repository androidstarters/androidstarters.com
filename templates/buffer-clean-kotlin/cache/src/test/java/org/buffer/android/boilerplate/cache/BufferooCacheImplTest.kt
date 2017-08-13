package <%= appPackage %>.cache

import <%= appPackage %>.cache.db.Db
import <%= appPackage %>.cache.db.DbOpenHelper
import <%= appPackage %>.cache.db.mapper.BufferooMapper
import <%= appPackage %>.cache.mapper.BufferooEntityMapper
import <%= appPackage %>.cache.model.CachedBufferoo
import <%= appPackage %>.cache.test.factory.BufferooFactory
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import kotlin.test.assertEquals

@RunWith(RobolectricTestRunner::class)
@Config(sdk = intArrayOf(21))
class BufferooCacheImplTest {

    private var entityMapper = BufferooEntityMapper()
    private var mapper = BufferooMapper()
    private var preferencesHelper = PreferencesHelper(RuntimeEnvironment.application)

    private val databaseHelper = BufferooCacheImpl(DbOpenHelper(RuntimeEnvironment.application),
            entityMapper, mapper, preferencesHelper)

    @Before
    fun setup() {
        databaseHelper.getDatabase().rawQuery("DELETE FROM " + Db.BufferooTable.TABLE_NAME, null)
    }

    @Test
    fun clearTablesCompletes() {
        val testObserver = databaseHelper.clearBufferoos().test()
        testObserver.assertComplete()
    }

    //<editor-fold desc="Save Bufferoos">
    @Test
    fun saveBufferoosCompletes() {
        val bufferooEntities = BufferooFactory.makeBufferooEntityList(2)

        val testObserver = databaseHelper.saveBufferoos(bufferooEntities).test()
        testObserver.assertComplete()
    }

    @Test
    fun saveBufferoosSavesData() {
        val bufferooCount = 2
        val bufferooEntities = BufferooFactory.makeBufferooEntityList(bufferooCount)

        databaseHelper.saveBufferoos(bufferooEntities).test()
        checkNumRowsInBufferoosTable(bufferooCount)
    }
    //</editor-fold>

    //<editor-fold desc="Get Bufferoos">
    @Test
    fun getBufferoosCompletes() {
        val testObserver = databaseHelper.getBufferoos().test()
        testObserver.assertComplete()
    }

    @Test
    fun getBufferoosReturnsData() {
        val bufferooEntities = BufferooFactory.makeBufferooEntityList(2)
        val cachedBufferoos = mutableListOf<CachedBufferoo>()
        bufferooEntities.forEach {
            cachedBufferoos.add(entityMapper.mapToCached(it))
        }
        insertBufferoos(cachedBufferoos)

        val testObserver = databaseHelper.getBufferoos().test()
        testObserver.assertValue(bufferooEntities)
    }
    //</editor-fold>

    private fun insertBufferoos(cachedBufferoos: List<CachedBufferoo>) {
        val database = databaseHelper.getDatabase()
        cachedBufferoos.forEach {
            database.insertOrThrow(Db.BufferooTable.TABLE_NAME, null,
                    mapper.toContentValues(it))
        }
    }

    private fun checkNumRowsInBufferoosTable(expectedRows: Int) {
        val bufferoosCursor = databaseHelper.getDatabase().query(Db.BufferooTable.TABLE_NAME,
                null, null, null, null, null, null)
        bufferoosCursor.moveToFirst()
        val numberOfRows = bufferoosCursor.count
        bufferoosCursor.close()
        assertEquals(expectedRows, numberOfRows)
    }

}