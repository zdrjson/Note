function post(t,e,n){n=n||"post";var i=document.createElement("form");i.setAttribute("method",n),i.setAttribute("action",t);for(var r in e)if(e.hasOwnProperty(r)){var o=document.createElement("input");o.setAttribute("type","hidden"),o.setAttribute("name",r),o.setAttribute("value",e[r]),i.appendChild(o)}document.body.appendChild(i),i.submit()}