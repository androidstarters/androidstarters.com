export function getFile(response) {
  console.log('Blobing..');
  var result = document.createElement('a');
  var contentDisposition = response.headers.get('Content-Disposition') || '';
  var filename = contentDisposition.split('filename=')[1];
  filename = filename.replace(/"/g,"")

  var blob = new Blob([response.data]);
  
  var link = document.createElement('a');
  link.href = window.URL.createObjectURL(blob);
  link.download = filename;  
  return link;  
}