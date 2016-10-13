/**
 * Created by json on 16/10/11.
 */

var ajax = new XMLHttpRequest();
ajax.open('GET','https://www.baidu.com',true);

ajax.onreadystatechange = handleStateChange;

var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function () {
  if (xhr.readyState === 4) {
      if (xhr.status === 200) {
          console.log(xhr.responseText);
      } else  {
          console.error(xhr.statusText);
      }
  }
};

xhr.onerror = function (e) {
    console.error(xhr.statusText);
}

xhr.open('GET','/endpoint', ture);

xhr.send(null);