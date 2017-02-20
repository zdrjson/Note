/**
 * Created by json on 16/4/26.
 */

var countNum = 0;
function count() {
    postMessage(countNum);
    countNum++;
    setTimeout(count,1000);
}
count();