"use strict";(self["webpackChunkjili"]=self["webpackChunkjili"]||[]).push([[16],{2016:function(t,e,a){a.r(e),a.d(e,{default:function(){return v}});var o=function(){var t=this,e=t._self._c;t._self._setupProxy;return e("div",{staticClass:"body"},[e("div",{staticClass:"header"},[e("van-nav-bar",{attrs:{title:"购物车"},scopedSlots:t._u([{key:"right",fn:function(){return[e("van-icon",{attrs:{name:"ellipsis",size:"18"}})]},proxy:!0}])})],1),e("div",{staticClass:"main"},[t.items.length>0?e("div",t._l(t.items,(function(a){return e("div",{key:a.scid},[e("div",{staticClass:"shop-item"},[e("van-swipe-cell",{scopedSlots:t._u([{key:"right",fn:function(){return[e("van-button",{staticClass:"delete-button",attrs:{square:"",text:"删除",type:"danger"},on:{click:function(e){return t.delItem(a.scid)}}})]},proxy:!0}],null,!0)},[e("van-card",{staticClass:"goods-card",attrs:{num:"",price:a.price,desc:a.comment,title:a.name,thumb:t.base+a.img},scopedSlots:t._u([{key:"tag",fn:function(){return[e("van-radio-group",{model:{value:t.tagRadio,callback:function(e){t.tagRadio=e},expression:"tagRadio"}},[e("van-tag",{attrs:{type:"danger"}},[t._v("标签")])],1)]},proxy:!0},{key:"num",fn:function(){},proxy:!0}],null,!0)})],1)],1),e("br")])})),0):e("div",{staticStyle:{overflow:"hidden"}},[e("van-cell-group",[e("van-cell",{attrs:{value:"您的购物车空空如也,快去添加吧"}})],1),e("br"),e("img",{staticStyle:{width:"95%",height:"100%","object-fit":"cover"},attrs:{src:a(8459),alt:""}})],1)]),e("van-divider",[t._v("到底啦")]),e("div",[e("van-submit-bar",{attrs:{price:t.money,"button-text":"结账"},on:{submit:t.onSubmit},scopedSlots:t._u([{key:"tip",fn:function(){return[t._v(" 小贴士:请注意检查地址信息哦 "),e("span",{staticStyle:{"text-decoration":"underline",color:"brown"},on:{click:t.onClickEditAddress}},[t._v("修改地址")])]},proxy:!0}])}),e("van-popup",{attrs:{position:"bottom",overlay:!0},model:{value:t.show.buy,callback:function(e){t.$set(t.show,"buy",e)},expression:"show.buy"}},[e("div",{staticStyle:{"text-align":"left",color:"gray",margin:"0.5rem"}},[t._v(" 请选择您的收货地址 ")]),e("div",[e("van-radio-group",{model:{value:t.radio,callback:function(e){t.radio=e},expression:"radio"}},[e("van-cell-group",t._l(t.addressList,(function(a){return e("van-cell",{key:a.aid,attrs:{clickable:"",title:`${a.name}  ${a.tel}                      `,label:`${a.province} ${a.city} ${a.county}`},on:{click:function(e){t.radio=a.aid}},scopedSlots:t._u([{key:"right-icon",fn:function(){return[e("van-radio",{attrs:{name:a.aid}})]},proxy:!0}],null,!0)})})),1)],1)],1),e("div",[e("van-cell-group",[e("van-field",{attrs:{"left-icon":"chat-o",clearable:"",label:"备注",type:"textarea",placeholder:"请输入备注,最长100字"},model:{value:t.orderComment,callback:function(e){t.orderComment=e},expression:"orderComment"}})],1)],1),e("br"),e("div",[e("van-button",{staticStyle:{width:"100%"},attrs:{type:"danger"},on:{click:t.submitOrder}},[t._v("提交订单")])],1)]),e("van-popup",{model:{value:t.show.pay,callback:function(e){t.$set(t.show,"pay",e)},expression:"show.pay"}},[e("div",[e("h3",[t._v(" 请支付 ")])]),e("div",[e("van-image",{attrs:{width:"100%",fit:"cover",src:"../assets/images/pay.jpg"}})],1)])],1),e("div",{staticClass:"footer"},[e("van-tabbar",{model:{value:t.active.footer,callback:function(e){t.$set(t.active,"footer",e)},expression:"active.footer"}},[e("van-tabbar-item",{attrs:{icon:"home-o",to:"/index",router:!0}},[t._v(" 首页 ")]),e("van-tabbar-item",{attrs:{icon:"search",router:!0}},[t._v(" 标签 ")]),e("van-tabbar-item",{attrs:{icon:"shopping-cart-o",to:"/shoppingcar",router:!0}},[t._v(" 购物车 ")]),e("van-tabbar-item",{attrs:{icon:"setting-o",to:"/person",router:!0}},[t._v(" 我的 ")])],1)],1)],1)},s=[],i=(a(7658),a(306)),n=a(521);const r={data(){return{active:{footer:""},show:{buy:!1,pay:!1},tagRadio:!1,value:"",checked:"",items:[],money:0,radio:"1",orderComment:"",addressList:[]}},computed:{base(){return i.Z.defaults.baseURL}},methods:{onSubmit(){this.getAddress(),this.show.buy=!0},onClickEditAddress(){},getAddress(){i.Z.get("/users/address").then((t=>{null!=t.data.data?this.addressList=t.data.data:(0,n.Z)("您尚未登录!")}))},submitOrder(){let t=[];for(let e=0;e<this.items.length;e++){const a=this.items[e],o={iid:a.iid,comment:this.orderComment,aid:this.radio};t.push(o)}i.Z.post("/users/buys",t).then((t=>{console.log(t.data),this.show.buy=!1;const e=this;setTimeout((function(){e.show.pay=!0}),2e3)}))},getItems(){i.Z.get("/users/caritems").then((t=>{if(this.money=0,null==t.data.data)return void(0,n.Z)(t.data.msg);this.items=t.data.data;const e=t.data.data;for(let a=0;a<e.length;a++){const t=e[a];this.money+=parseFloat(parseFloat(t.price).toFixed(2))}this.money*=100}))},delItem(t){let e=new FormData;e.set("scid",t),i.Z.post("/users/delsc",e).then((t=>{(0,n.Z)(t.data.msg),t.data.data&&this.getItems()}))}},mounted(){console.log("shopping..."),this.getItems()}};var l=r,c=l,d=a(1001),u=(0,d.Z)(c,o,s,!1,null,"454a28ab",null),v=u.exports},8459:function(t,e,a){t.exports=a.p+"img/none.4e9ba600.png"}}]);
//# sourceMappingURL=16.fcaf274c.js.map