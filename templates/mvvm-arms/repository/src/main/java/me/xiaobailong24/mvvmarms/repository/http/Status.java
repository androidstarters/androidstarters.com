package <%= appPackage %>.repository.http;

/**
 * @author xiaobailong24
 * @date 2017/9/7
 * 数据请求状态
 */
public enum Status {
    /**
     * 正在加载中
     */
    LOADING,

    /**
     * 加载成功
     */
    SUCCESS,

    /**
     * 加载失败
     */
    ERROR
}
