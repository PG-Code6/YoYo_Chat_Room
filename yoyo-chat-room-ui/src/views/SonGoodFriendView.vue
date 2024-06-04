<template>
<div>
  <el-header>
    <div style="display: flex;align-items: center;">
    <img src="../assets/表情.png" align="middle" width="40vh" height="40vh">
    <span class="span_header_Style">好友列表</span>
    </div>
  </el-header>

  <el-main>

    <div  style="width: 100%;">
      <button class="Dynamic2" @click="openNewWindow(item)" v-for="(item,index) in users" :key="index">
        <div style="display: flex;align-items: center;">
					<img src="https://img.pg-code-go.com" class="avatar">
          <span style="font-weight: bold;text-align: start;line-height: 20px;margin-top: 10px;">用户名:{{item.username}}<br><span style="font-weight: normal;">个性签名：今天也在嘻嘻吗？</span></span>
        </div>
      </button>

<!--      <button class="Dynamic2" @click="openNewWindow()">-->
<!--        <img src="../assets/男人像-1.png" class="avatar">-->
<!--        <div class="Dynamic">-->
<!--          <span class="friendtext">队长2</span>-->
<!--          <span class="friendtext2">个性签名：</span>-->
<!--          <span class="friendtext">在报错中生存，晚安！hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh</span>-->
<!--        </div>-->
<!--      </button>-->
    </div>

  </el-main>
</div>

</template>

<script>
let socket;
export default {
  name: "SonGoodFriendView",
  data() {
    return {
      isCollapse: true,
      friends:[
        {
          avatar:require('@/assets/男人像-1.png'),
          name:'队长1',
          sign:'个性签名：',
          sign_content:'世界对方促进'
        },
        {
          avatar:require('@/assets/男人像-1.png'),
          name:'队长2',
          sign:'个性签名：',
          sign_content:'gvjvhjvhjg'
        }
      ],
			user: {},
			users: [],
			avatar:require('@/assets/男人像-1.png')
    };
  },
	created() {
		this.init();
	},
	methods: {
		init() {
			this.user = localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
			let username = this.user.username;
			let _this = this;
			if (typeof (WebSocket) == "undefined") {
				console.log("您的浏览器不支持WebSocket");
			} else {
				console.log("您的浏览器支持WebSocket");
				let socketUrl = "ws://localhost:9091/imserver/" + username;
				if (socket != null) {
					socket.close();
					socket = null;
				}
				// 开启一个websocket服务
				socket = new WebSocket(socketUrl);
				//打开事件
				socket.onopen = function () {
					console.log("websocket已打开");
				};
				//  浏览器端收消息，获得从服务端发送过来的文本消息
				socket.onmessage = function (msg) {
					console.log("收到数据====" + msg.data)
					let data = JSON.parse(msg.data)  // 对收到的json数据进行解析， 类似这样的： {"users": [{"username": "zhang"},{ "username": "admin"}]}
					if (data.users) {  // 获取在线人员信息
						_this.users = data.users.filter(user => user.username !== username)  // 获取当前连接的所有用户信息，并且排除自身，自己不会出现在自己的聊天列表里
					}
				};
				//关闭事件
				socket.onclose = function () {
					console.log("websocket已关闭");
				};
				//发生了错误事件
				socket.onerror = function (e) {
					console.log(e);
					console.log("websocket发生了错误");
				}
			}
		},
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    openNewWindow(data) {
      // window.open('http://localhost:8080', '_self');
      console.log('开始跳转：'+data.name)
      // this.$router.push({
      //   name:'friendchat',
      //   params: {friend:data}
      // })
      this.$router.push('/friendchat');
      localStorage.setItem('friend',JSON.stringify(data));
    }

  }
}

</script>

<style scoped>


.el-main::-webkit-scrollbar {
	display: none;
}

.avatar {
  background: rgb(211, 211, 211);
  width: 4vw;
  height:6vh;
  border-radius: 50%;
  margin-left: 20px;
  margin-right: 10px;
  margin-top: 10px;
}
.Dynamic{
  /*  border: 1px red solid;*/
  float:left;
  display: flex;
  flex-direction: column;

}
.Dynamic2{
  /*  border: 1px #bcf357 solid;*/
  /*float:left;*/
  display: flex;
  flex-direction: column;
  /*background-color: #8ef2ff;*/
  background-color: rgb(211,183,216);
  /*  opacity:0.5;*/
  height: auto;
  width: 100%;
  border-radius: 15px;
  margin-top: 10px;
  margin-left: 15px;
  /*border: 2px red solid;*/
}
.Dynamic2:hover {
  /*background-color: gold;*/
  background-color: rgba(255,255,255,0.1) !important;
}

/*.friendtext{*/
/*  font-size: 20px;*/
/*  color:white;*/
/*  text-align: left;*/
/*  margin-top: 10px;*/
/*  margin-bottom: 10px;*/
/*  width: 65vw;*/
/*  !*  border: 1px solid #ff0000;*!*/
/*  overflow-wrap: break-word;*/
/*}*/
.friendtext2{
  font-size: 15px;
  color: #9f9f9f;
  text-align: left;
  margin-top: 5px;
}
.span_header_Style{
  color: #000;
}
.el-header{
	display: flex;
	align-items: center;
  border-bottom: 1px #605f5f solid;
}
</style>
