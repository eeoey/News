(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-343257e0"],{3244:function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"channel-news"},[a("Header"),a("div",{staticClass:"type-title"},[e._v(e._s(e.channelName))]),e.isLoading?a("Loading"):a("NewsList",{attrs:{news:e.news}}),a("Pagination",{attrs:{page:e.page,limit:e.limit,total:e.total,panelNumber:e.panelNumber},on:{pageChange:e.handleChange}})],1)},r=[],s=a("1da1"),i=(a("96cf"),a("b0c0"),a("1cee")),c=a("0418"),u=a("3a5e"),o=a("dc4d"),l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return e.total>0?a("div",{staticClass:"pager"},[a("a",{staticClass:"pager-item",class:{disabled:1===e.page},attrs:{href:"#"},on:{click:function(t){return t.preventDefault(),e.handleChange(1)}}},[e._v("首页")]),a("a",{staticClass:"pager-item",class:{disabled:1===e.page},attrs:{href:"#"},on:{click:function(t){return t.preventDefault(),e.handleChange(e.page-1)}}},[e._v("上一页")]),e._l(e.numbers,(function(t){return a("a",{key:t,staticClass:"pager-item",class:{active:t===e.page},attrs:{href:"#"},on:{click:function(a){return a.preventDefault(),e.handleChange(t)}}},[e._v(e._s(t))])})),a("a",{staticClass:"pager-item",class:{disabled:e.page===e.pageNumber},attrs:{href:"#"},on:{click:function(t){return t.preventDefault(),e.handleChange(e.page+1)}}},[e._v("下一页")]),a("a",{staticClass:"pager-item",class:{disabled:e.page===e.pageNumber},attrs:{href:"#"},on:{click:function(t){return t.preventDefault(),e.handleChange(e.pageNumber)}}},[e._v("尾页")]),a("span",{staticClass:"pager-text"},[a("i",[e._v(e._s(e.page))]),e._v(" / "),a("i",[e._v(e._s(e.pageNumber))])])],2):e._e()},p=[],f=(a("a9e3"),{props:{page:{default:1,type:Number},total:{default:0,type:Number},limit:{default:10,type:Number},panelNumber:{default:10,type:Number}},computed:{pageNumber:function(){return Math.ceil(this.total/this.limit)},numbers:function(){for(var e=[],t=this.minNumber;t<this.maxNumber;t++)e.push(t);return e},minNumber:function(){var e=this.page-this.panelNumber/2;return e<1&&(e=1),e},maxNumber:function(){var e=this.minNumber+this.panelNumber-1;return e>this.pageNumber&&(e=this.pageNumber),e}},methods:{handleChange:function(e){e<1?e=1:e>this.pageNumber&&(e=this.pageNumber),e!==this.page&&this.$emit("pageChange",e)}}}),h=f,d=(a("87e6"),a("2877")),g=Object(d["a"])(h,l,p,!1,null,"184195f6",null),m=g.exports,b={components:{NewsList:o["a"],Pagination:m,Loading:u["a"],Header:c["a"]},data:function(){return{page:1,limit:10,total:0,panelNumber:10,news:[],isLoading:!0}},watch:{"$route.params.id":{immediate:!0,handler:function(){this.page=1,this.setNews()}}},computed:{channelName:function(){if(this.$store.state.news.channels.length>0)for(var e=this.$store.state.news.channels,t=0;t<e.length;t++){var a=e[t];if(a.id==this.$route.params.id)return a.name}return""}},methods:{handleChange:function(e){this.page=e,this.setNews()},setNews:function(){var e=this;return Object(s["a"])(regeneratorRuntime.mark((function t(){var a,n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return e.isLoading=!0,t.next=3,Object(i["c"])(e.$route.params.id,e.page,e.limit);case 3:a=t.sent,n=a.data.data,e.total=n.total,e.news=n.rows,e.isLoading=!1;case 8:case"end":return t.stop()}}),t)})))()}}},v=b,N=(a("413b"),Object(d["a"])(v,n,r,!1,null,"3a4a908e",null));t["default"]=N.exports},"3a5e":function(e,t,a){"use strict";var n=function(){var e=this,t=e.$createElement;e._self._c;return e._m(0)},r=[function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"loading"},[a("span"),a("span"),a("span"),a("span"),a("span")])}],s=(a("c7bc"),a("2877")),i={},c=Object(s["a"])(i,n,r,!1,null,"71977665",null);t["a"]=c.exports},"413b":function(e,t,a){"use strict";a("559e")},4732:function(e,t,a){},"559e":function(e,t,a){},5899:function(e,t){e.exports="\t\n\v\f\r                　\u2028\u2029\ufeff"},"58a8":function(e,t,a){var n=a("1d80"),r=a("5899"),s="["+r+"]",i=RegExp("^"+s+s+"*"),c=RegExp(s+s+"*$"),u=function(e){return function(t){var a=String(n(t));return 1&e&&(a=a.replace(i,"")),2&e&&(a=a.replace(c,"")),a}};e.exports={start:u(1),end:u(2),trim:u(3)}},7156:function(e,t,a){var n=a("861d"),r=a("d2bb");e.exports=function(e,t,a){var s,i;return r&&"function"==typeof(s=t.constructor)&&s!==a&&n(i=s.prototype)&&i!==a.prototype&&r(e,i),e}},"85d9":function(e,t,a){"use strict";a("4732")},"87e6":function(e,t,a){"use strict";a("e325")},"947b":function(e,t,a){},a9e3:function(e,t,a){"use strict";var n=a("83ab"),r=a("da84"),s=a("94ca"),i=a("6eeb"),c=a("5135"),u=a("c6b6"),o=a("7156"),l=a("c04e"),p=a("d039"),f=a("7c73"),h=a("241c").f,d=a("06cf").f,g=a("9bf2").f,m=a("58a8").trim,b="Number",v=r[b],N=v.prototype,_=u(f(N))==b,C=function(e){var t,a,n,r,s,i,c,u,o=l(e,!1);if("string"==typeof o&&o.length>2)if(o=m(o),t=o.charCodeAt(0),43===t||45===t){if(a=o.charCodeAt(2),88===a||120===a)return NaN}else if(48===t){switch(o.charCodeAt(1)){case 66:case 98:n=2,r=49;break;case 79:case 111:n=8,r=55;break;default:return+o}for(s=o.slice(2),i=s.length,c=0;c<i;c++)if(u=s.charCodeAt(c),u<48||u>r)return NaN;return parseInt(s,n)}return+o};if(s(b,!v(" 0o1")||!v("0b1")||v("+0x1"))){for(var w,E=function(e){var t=arguments.length<1?0:e,a=this;return a instanceof E&&(_?p((function(){N.valueOf.call(a)})):u(a)!=b)?o(new v(C(t)),a,E):C(t)},I=n?h(v):"MAX_VALUE,MIN_VALUE,NaN,NEGATIVE_INFINITY,POSITIVE_INFINITY,EPSILON,isFinite,isInteger,isNaN,isSafeInteger,MAX_SAFE_INTEGER,MIN_SAFE_INTEGER,parseFloat,parseInt,isInteger,fromString,range".split(","),y=0;I.length>y;y++)c(v,w=I[y])&&!c(E,w)&&g(E,w,d(v,w));E.prototype=N,N.constructor=E,i(r,b,E)}},b0c0:function(e,t,a){var n=a("83ab"),r=a("9bf2").f,s=Function.prototype,i=s.toString,c=/^\s*function ([^ (]*)/,u="name";n&&!(u in s)&&r(s,u,{configurable:!0,get:function(){try{return i.call(this).match(c)[1]}catch(e){return""}}})},c7bc:function(e,t,a){"use strict";a("947b")},dc4d:function(e,t,a){"use strict";var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"news-list"},e._l(e.news,(function(t,n){return a("div",{key:t.id,staticClass:"news-item-normal",attrs:{index:n}},[t.photoUrl?a("div",{staticClass:"image"},[a("a",{attrs:{href:"/Content/"+t.id,target:"_blank"}},[a("img",{attrs:{src:t.photoUrl,alt:"图片"}})])]):e._e(),a("div",{staticClass:"words"},[a("h3",{staticClass:"title"},[a("a",{attrs:{href:"/Content/"+t.id,target:"_blank"}},[e._v(e._s(t.title))])]),a("div",{staticClass:"aside"},[a("span",[e._v(e._s(t.channelName))]),a("span",[a("a",{attrs:{href:t.sourceUrl}},[e._v(" 来源："+e._s(t.source)+" ")])]),a("span",[e._v("发布日期："+e._s(t.createTime))])]),a("div",{staticClass:"content",domProps:{innerHTML:e._s(t.des||t.content)}})])])})),0)},r=[],s={props:{news:{type:Array,default:function(){return[]}}}},i=s,c=(a("85d9"),a("2877")),u=Object(c["a"])(i,n,r,!1,null,"336d0001",null);t["a"]=u.exports},e325:function(e,t,a){}}]);
//# sourceMappingURL=chunk-343257e0.1d958012.js.map