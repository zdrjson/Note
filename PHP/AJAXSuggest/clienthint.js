var xmlHttp

function showHint(str)
{
	if (str.length==0) {
		document.getElementById("txtHint").innerHTML=""
		return
	}
	xmlHttp=GetXmlHttpObject()
	if (xmlHttp==null)
	{
		alert('Browser does not support HTTP Request')
		return
	}
	var url = "gethint.php"
	url=url+"?q"+str
	url=url+"&sid"+Math.random() 
	xmlHttp.onreadystatechange=stateChanghed
	xmlHttp.open("GET", url, true)
	xmlHttp.send(null)
}

function stateChanged()
{
	if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete") 
	{
		document.getElementById("txtHint").innerHTML=xmlHttp.responseText
	}
}

function GetXmlHttpObject()
{
	var xmlHttp=null;
	try {
		//Firefox, Opera 8.0+, Safari
		xmlHttp=new new XMLHttpRequest();
	} catch(e) {
		// statements
		console.log(e);
		try {
			// Internet Explorer
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(e) {
			// statements
			console.log(e);
			xmlHttp = new ActiveXObject('Microsoft.XMLHTTP');
		}
	}
    return xmlHttp;
}