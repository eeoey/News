(function(e){function t(t){for(var r,a,o=t[0],i=t[1],s=t[2],p=0,f=[];p<o.length;p++)a=o[p],Object.prototype.hasOwnProperty.call(u,a)&&u[a]&&f.push(u[a][0]),u[a]=0;for(r in i)Object.prototype.hasOwnProperty.call(i,r)&&(e[r]=i[r]);d&&d(t);while(f.length)f.shift()();return c.push.apply(c,s||[]),n()}function n(){for(var e,t=0;t<c.length;t++){for(var n=c[t],r=!0,a=1;a<n.length;a++){var o=n[a];0!==u[o]&&(r=!1)}r&&(c.splice(t--,1),e=i(i.s=n[0]))}return e}var r={},a={app:0},u={app:0},c=[];function o(e){return i.p+"js/"+({}[e]||e)+"."+{"chunk-25cac8e4":"0a6f02a3","chunk-2873ddaa":"5680cae4","chunk-343257e0":"1d958012","chunk-4ecf52ee":"105b80ab","chunk-558f2470":"e1245227","chunk-59842446":"fa1ff0bd","chunk-7f7fb6ba":"0c4005eb","chunk-457261a2":"801018c4","chunk-a6ad2ec8":"b25b6f7d"}[e]+".js"}function i(t){if(r[t])return r[t].exports;var n=r[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,i),n.l=!0,n.exports}i.e=function(e){var t=[],n={"chunk-25cac8e4":1,"chunk-2873ddaa":1,"chunk-343257e0":1,"chunk-4ecf52ee":1,"chunk-558f2470":1,"chunk-59842446":1,"chunk-7f7fb6ba":1,"chunk-457261a2":1,"chunk-a6ad2ec8":1};a[e]?t.push(a[e]):0!==a[e]&&n[e]&&t.push(a[e]=new Promise((function(t,n){for(var r="css/"+({}[e]||e)+"."+{"chunk-25cac8e4":"bd173594","chunk-2873ddaa":"2b54a713","chunk-343257e0":"5c687eb7","chunk-4ecf52ee":"161b0c51","chunk-558f2470":"95cf74b8","chunk-59842446":"f275f604","chunk-7f7fb6ba":"95cf74b8","chunk-457261a2":"8006ce32","chunk-a6ad2ec8":"8742d16f"}[e]+".css",u=i.p+r,c=document.getElementsByTagName("link"),o=0;o<c.length;o++){var s=c[o],p=s.getAttribute("data-href")||s.getAttribute("href");if("stylesheet"===s.rel&&(p===r||p===u))return t()}var f=document.getElementsByTagName("style");for(o=0;o<f.length;o++){s=f[o],p=s.getAttribute("data-href");if(p===r||p===u)return t()}var d=document.createElement("link");d.rel="stylesheet",d.type="text/css",d.onload=t,d.onerror=function(t){var r=t&&t.target&&t.target.src||u,c=new Error("Loading CSS chunk "+e+" failed.\n("+r+")");c.code="CSS_CHUNK_LOAD_FAILED",c.request=r,delete a[e],d.parentNode.removeChild(d),n(c)},d.href=u;var l=document.getElementsByTagName("head")[0];l.appendChild(d)})).then((function(){a[e]=0})));var r=u[e];if(0!==r)if(r)t.push(r[2]);else{var c=new Promise((function(t,n){r=u[e]=[t,n]}));t.push(r[2]=c);var s,p=document.createElement("script");p.charset="utf-8",p.timeout=120,i.nc&&p.setAttribute("nonce",i.nc),p.src=o(e);var f=new Error;s=function(t){p.onerror=p.onload=null,clearTimeout(d);var n=u[e];if(0!==n){if(n){var r=t&&("load"===t.type?"missing":t.type),a=t&&t.target&&t.target.src;f.message="Loading chunk "+e+" failed.\n("+r+": "+a+")",f.name="ChunkLoadError",f.type=r,f.request=a,n[1](f)}u[e]=void 0}};var d=setTimeout((function(){s({type:"timeout",target:p})}),12e4);p.onerror=p.onload=s,document.head.appendChild(p)}return Promise.all(t)},i.m=e,i.c=r,i.d=function(e,t,n){i.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},i.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},i.t=function(e,t){if(1&t&&(e=i(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(i.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)i.d(n,r,function(t){return e[t]}.bind(null,r));return n},i.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return i.d(t,"a",t),t},i.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},i.p="/",i.oe=function(e){throw console.error(e),e};var s=window["webpackJsonp"]=window["webpackJsonp"]||[],p=s.push.bind(s);s.push=t,s=s.slice();for(var f=0;f<s.length;f++)t(s[f]);var d=p;c.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"1a25":function(e,t,n){},"1cee":function(e,t,n){"use strict";n.d(t,"b",(function(){return o})),n.d(t,"c",(function(){return s})),n.d(t,"f",(function(){return f})),n.d(t,"a",(function(){return l})),n.d(t,"e",(function(){return m})),n.d(t,"d",(function(){return b}));var r=n("1da1"),a=(n("96cf"),n("bc3a")),u=n.n(a),c="b03d91efaa1c48b289fcec8da2882601";function o(){return i.apply(this,arguments)}function i(){return i=Object(r["a"])(regeneratorRuntime.mark((function e(){var t;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,u.a.post("/api/v1/category/list",{headers:{Authorization:"APPCODE ".concat(c)}});case 2:return t=e.sent,e.abrupt("return",t.data.data);case 4:case"end":return e.stop()}}),e)}))),i.apply(this,arguments)}function s(e){return p.apply(this,arguments)}function p(){return p=Object(r["a"])(regeneratorRuntime.mark((function e(t){var n,r,a,o=arguments;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return n=o.length>1&&void 0!==o[1]?o[1]:1,r=o.length>2&&void 0!==o[2]?o[2]:10,a=u.a.post("/api/v1/content/?pageNum="+n+"&pageSize="+r,{categoryId:t,pageNum:n,pageSize:r},{headers:{Authorization:"APPCODE ".concat(c)}}),e.abrupt("return",a);case 4:case"end":return e.stop()}}),e)}))),p.apply(this,arguments)}function f(e,t){return d.apply(this,arguments)}function d(){return d=Object(r["a"])(regeneratorRuntime.mark((function e(t,n){var r,a,o,i=arguments;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return r=i.length>2&&void 0!==i[2]?i[2]:1,a=i.length>3&&void 0!==i[3]?i[3]:10,o=u.a.post("/api/v1/content/search?pageNum="+r+"&pageSize="+a+"&keyword="+t,{categoryId:n,pageNum:r,pageSize:a,keyword:t},{headers:{Authorization:"APPCODE ".concat(c)}}),e.abrupt("return",o);case 4:case"end":return e.stop()}}),e)}))),d.apply(this,arguments)}function l(e,t){return h.apply(this,arguments)}function h(){return h=Object(r["a"])(regeneratorRuntime.mark((function e(t,n){var r;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,u.a.post("/api/v1/content/detail?id="+t+"&page_size="+n);case 2:return r=e.sent,e.abrupt("return",r.data);case 4:case"end":return e.stop()}}),e)}))),h.apply(this,arguments)}function m(e){return g.apply(this,arguments)}function g(){return g=Object(r["a"])(regeneratorRuntime.mark((function e(t){var n;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,u.a.get("/api/v1/content/recommend?userId="+t);case 2:return n=e.sent,e.abrupt("return",n.data);case 4:case"end":return e.stop()}}),e)}))),g.apply(this,arguments)}function b(e){return v.apply(this,arguments)}function v(){return v=Object(r["a"])(regeneratorRuntime.mark((function e(t){var n;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,u.a.post("/api/v1/content/prepublish",t);case 2:return n=e.sent,e.abrupt("return",n.data);case 4:case"end":return e.stop()}}),e)}))),v.apply(this,arguments)}u.a.defaults.withCredentials=!0},"3afe":function(e,t,n){"use strict";n.d(t,"e",(function(){return c})),n.d(t,"a",(function(){return i})),n.d(t,"f",(function(){return p})),n.d(t,"h",(function(){return f})),n.d(t,"g",(function(){return l})),n.d(t,"c",(function(){return m})),n.d(t,"d",(function(){return b})),n.d(t,"b",(function(){return w}));var r=n("1da1"),a=(n("96cf"),n("bc3a")),u=n.n(a);function c(e){return o.apply(this,arguments)}function o(){return o=Object(r["a"])(regeneratorRuntime.mark((function e(t){var n;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return u.a.defaults.withCredentials=!0,e.next=3,u.a.post("/api/v1/user/login?username="+t.username+"&password="+t.password);case 3:return n=e.sent,e.abrupt("return",n.data);case 5:case"end":return e.stop()}}),e)}))),o.apply(this,arguments)}function i(){return s.apply(this,arguments)}function s(){return s=Object(r["a"])(regeneratorRuntime.mark((function e(){var t;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return u.a.defaults.withCredentials=!0,e.next=3,u.a.get("/api/v1/user/info");case 3:return t=e.sent,e.abrupt("return",t.data.data);case 5:case"end":return e.stop()}}),e)}))),s.apply(this,arguments)}function p(){localStorage.removeItem("token"),u.a.post("/logout").then((function(){console.info("退出")}))}function f(e){return d.apply(this,arguments)}function d(){return d=Object(r["a"])(regeneratorRuntime.mark((function e(t){var n;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return u.a.defaults.withCredentials=!0,e.next=3,u.a.post("/api/v1/user/update",t);case 3:return n=e.sent,e.abrupt("return",n.data);case 5:case"end":return e.stop()}}),e)}))),d.apply(this,arguments)}function l(e){return h.apply(this,arguments)}function h(){return h=Object(r["a"])(regeneratorRuntime.mark((function e(t){var n;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,u.a.post("/api/v1/user/register",t);case 2:return n=e.sent,e.abrupt("return",n.data);case 4:case"end":return e.stop()}}),e)}))),h.apply(this,arguments)}function m(e){return g.apply(this,arguments)}function g(){return g=Object(r["a"])(regeneratorRuntime.mark((function e(t){var n;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return u.a.defaults.withCredentials=!0,e.next=3,u.a.post("/api/v1/collect/favorite?articleId="+t);case 3:return n=e.sent,e.abrupt("return",n.data);case 5:case"end":return e.stop()}}),e)}))),g.apply(this,arguments)}function b(e){return v.apply(this,arguments)}function v(){return v=Object(r["a"])(regeneratorRuntime.mark((function e(t){var n;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,u.a.post("/api/v1/collect/like?articleId="+t);case 2:return n=e.sent,e.abrupt("return",n.data);case 4:case"end":return e.stop()}}),e)}))),v.apply(this,arguments)}function w(e,t){return k.apply(this,arguments)}function k(){return k=Object(r["a"])(regeneratorRuntime.mark((function e(t,n){var r,a;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return r={content:t,cId:n},e.next=3,u.a.post("/api/v1/comments/add",r);case 3:return a=e.sent,e.abrupt("return",a.data);case 5:case"end":return e.stop()}}),e)}))),k.apply(this,arguments)}u.a.defaults.withCredentials=!0},"56d7":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d");var r=n("2b0e"),a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("div",{staticClass:"container"},[n("router-view")],1)])},u=[],c={components:{},data:function(){return{}}},o=c,i=n("2877"),s=Object(i["a"])(o,a,u,!1,null,null,null),p=s.exports,f=(n("d3b7"),n("3ca3"),n("ddb0"),n("8c4f"));r["default"].use(f["a"]);var d=[{path:"/",name:"Home",component:function(){return Promise.all([n.e("chunk-2873ddaa"),n.e("chunk-7f7fb6ba")]).then(n.bind(null,"bb51"))}},{path:"/search",name:"Search",component:function(){return Promise.all([n.e("chunk-2873ddaa"),n.e("chunk-558f2470")]).then(n.bind(null,"2d3b"))}},{path:"/login",name:"Login",component:function(){return n.e("chunk-457261a2").then(n.bind(null,"a55b"))}},{path:"/logup",name:"Logup",component:function(){return n.e("chunk-a6ad2ec8").then(n.bind(null,"d53a"))}},{path:"/channel/:id",name:"Channel",component:function(){return Promise.all([n.e("chunk-2873ddaa"),n.e("chunk-343257e0")]).then(n.bind(null,"3244"))}},{path:"/content/:id",name:"Content",component:function(){return Promise.all([n.e("chunk-2873ddaa"),n.e("chunk-4ecf52ee")]).then(n.bind(null,"29ff"))}},{path:"/personal",name:"personal",component:function(){return Promise.all([n.e("chunk-2873ddaa"),n.e("chunk-59842446")]).then(n.bind(null,"90ab"))},meta:{auth:!0}},{path:"*",component:function(){return n.e("chunk-25cac8e4").then(n.bind(null,"9703"))}}],l=new f["a"]({routes:d,mode:"history"}),h=l,m=n("2f62"),g=n("1da1"),b=(n("96cf"),n("1cee")),v={namespaced:!0,state:{channels:[],isLoading:!1},mutations:{setIsLoading:function(e,t){e.isLoading=t},setData:function(e,t){e.channels=t}},actions:{fetchData:function(e){return Object(g["a"])(regeneratorRuntime.mark((function t(){var n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return e.commit("setIsLoading",!0),t.next=3,Object(b["b"])();case 3:n=t.sent,e.commit("setData",n),e.commit("setIsLoading",!1);case 6:case"end":return t.stop()}}),t)})))()}}},w=n("3afe"),k={namespaced:!0,state:{userData:null,isLoading:!1},mutations:{setIsLoading:function(e,t){e.isLoading=t},setUserData:function(e,t){e.userData=t}},actions:{login:function(e,t){return Object(g["a"])(regeneratorRuntime.mark((function n(){var r;return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:return e.commit("setIsLoading",!0),n.next=3,Object(w["e"])(t);case 3:return r=n.sent,0===r.code&&e.commit("setUserData",r.user),e.commit("setIsLoading",!1),n.abrupt("return",r);case 7:case"end":return n.stop()}}),n)})))()},accessConfig:function(e){return Object(g["a"])(regeneratorRuntime.mark((function t(){var n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return e.commit("setIsLoading",!0),t.next=3,Object(w["a"])();case 3:n=t.sent,e.commit("setUserData",n),e.commit("setIsLoading",!1);case 6:case"end":return t.stop()}}),t)})))()},logout:function(e){Object(w["f"])(),e.commit("setUserData",null)}}};r["default"].use(m["a"]);var y=new m["a"].Store({modules:{news:v,user:k}}),x=n("5c96"),O=n.n(x);n("0fae"),n("1a25"),n("7371");r["default"].config.productionTip=!1,h.beforeEach((function(e,t,n){document.title="新闻管理系统",n()})),r["default"].use(O.a),y.dispatch("news/fetchData"),y.dispatch("user/accessConfig"),new r["default"]({router:h,store:y,render:function(e){return e(p)}}).$mount("#app")},7371:function(e,t,n){}});
//# sourceMappingURL=app.0eace16f.js.map