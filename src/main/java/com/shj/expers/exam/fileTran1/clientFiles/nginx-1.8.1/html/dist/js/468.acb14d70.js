"use strict";(self["webpackChunkjili"]=self["webpackChunkjili"]||[]).push([[468],{5468:function(t,e,a){a.r(e),a.d(e,{default:function(){return f}});var s=function(){var t=this,e=t._self._c;t._self._setupProxy;return e("div",{staticClass:"body"},[e("div",{staticClass:"header"},[e("van-nav-bar",{attrs:{title:"标题","z-index":"999",fixed:"",placeholder:"","left-text":"返回","left-arrow":""},on:{"click-left":t.goBack}},[e("van-icon",{attrs:{slot:"right",name:"search"},slot:"right"})],1)],1),e("div",{staticClass:"main"},[e("van-tabs",{attrs:{"swipe-threshold":"4",ellipsis:!1},on:{change:t.classifyChange},scopedSlots:t._u([{key:"nav-left",fn:function(){return[e("div",{staticStyle:{"margin-top":"0.6rem"}},[e("van-tag",{attrs:{color:"#f2826a",size:"large"}},[t._v("类别")])],1)]},proxy:!0}]),model:{value:t.active,callback:function(e){t.active=e},expression:"active"}},t._l(t.classes,(function(a){return e("van-tab",{key:a.cid,attrs:{type:"card",title:a.classname}},t._l(t.items,(function(s){return e("div",{key:s.iid},[e("van-card",{attrs:{tag:a.classname,price:s.price,desc:s.comment,title:s.name,thumb:t.base+s.img,"origin-price":parseInt(s.price)+15},scopedSlots:t._u([{key:"num",fn:function(){return[t._v(" 库存: "+t._s(s.quantity)+" ")]},proxy:!0},{key:"footer",fn:function(){return[e("van-button",{attrs:{type:"danger",size:"mini"},on:{click:function(e){return t.addShopCar(s.iid)}}},[t._v("加入购物车")]),e("van-button",{attrs:{type:"primary",size:"mini"},on:{click:function(e){return t.goItemInfo(s.iid)}}},[t._v("购买")])]},proxy:!0}],null,!0)}),e("br")],1)})),0)})),1)],1),e("div",{staticClass:"footer"})])},i=[],n=(a(7658),a(306)),r=a(521);const c={data(){return{active:"0",classes:[],items:[]}},computed:{base(){return n.Z.defaults.baseURL}},methods:{goBack(){this.$router.push("/index")},classifyChange(t,e){n.Z.get(`/admin/getic?cid=${this.classes[t].cid}&title=${e}`).then((t=>{this.items=t.data.data}))},getItemClasses(){n.Z.get("/admin/itemclasses").then((t=>{this.classes=t.data.data}))},addShopCar(t){let e=new FormData;e.set("iid",t),n.Z.post("/users/addshopcar",e).then((t=>{(0,r.Z)(t.data.msg)}))},goItemInfo(t){this.$router.push(`/iteminfo?iid=${t}`)}},mounted(){this.getItemClasses()}};var o=c,l=o,d=a(1001),u=(0,d.Z)(l,s,i,!1,null,null,null),f=u.exports}}]);
//# sourceMappingURL=468.acb14d70.js.map