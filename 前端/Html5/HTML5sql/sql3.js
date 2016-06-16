/**
 * Created by json on 16/5/2.
 */

var datatable = null;
var db = openDatabase("MyData","","My Database",1024*100);
function init() {
    datatable = document.getElementById("datatable");
}

function removeAllData() {
    for(var i = datatable.hasChildNodes.length - 1; i>=0; i--) {
        datatable.removeChild(datatable.childNodes[i]);
    }
    var tr = document.createElement("tr");
    var th1 = document.createElement("th");
    var th2 = document.createElement("th");
    var th3 = document.createElement("th");
    th1.innerHTML = "姓名";
    th2.innerHTML = "留言";
    th3.innerHTML = "时间";
    tr.appendChild(th1);
    tr.appendChild(th2);
    tr.appendChild(th3);
    datatable.appendChild(tr);

}

function showData(row) {
    var tr = document.createElement("tr");
    var td1 = document.createElement("td");
    td1.innerHTML = row.name;
    var td2 = document.createElement("td");
    td2.innerHTML = row.message;
    var td3 = document.createElement("td");
    var t = new Date();
    t.setTime(row.time);
    td3.innerHTML = t.toLocaleDateString() + "  " +t.toLocaleTimeString();
    tr.appendChild(td1);
    tr.appendChild()
}