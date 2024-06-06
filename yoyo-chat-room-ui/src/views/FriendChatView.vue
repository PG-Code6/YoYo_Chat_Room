<template>
  <el-main>

    <el-header>
      <div style="display: flex;align-items: center;">
      <img src="../assets/表情.png" align="middle" width="40vh" height="40vh">
      <span class="span_header_Style">{{chatUser}}</span>
      </div>
    </el-header>

    <div class="talk" v-show="flag">
      <div >
        <div >
          <!--          <svg class="icon" aria-hidden="true">-->
          <!--            <use xlink:href="#icon-gengduocaozuo"></use>-->
          <!--          </svg>-->
          <!--          <svg class="icon" aria-hidden="true" @click="exit">-->
          <!--            <use xlink:href="#icon-guanbi"></use>-->
          <!--          </svg>-->
        </div>
      </div>


      <div class="talk-content " v-html="content">

        <!--<div v-for="item  in contentDiv" style="margin-top: 20px">-->


        <!--  <div style="text-align: center">-->
        <!--    <p style="font-size: 1px;color: #9b9b9b"> {{item.time}}</p>-->
        <!--  </div>-->
        <!--  <div style="display: flex;">-->

        <!--    <div class="name_right" v-if="item.show">-->
        <!--      <p style="font-size: 15px; "> {{item.name}} </p>-->
        <!--    </div>-->
        <!--    <div class="url_right" v-if="item.show">-->
        <!--      <el-avatar shape="circle" :size="50" :src="item.url"></el-avatar>-->
        <!--    </div>-->
        <!--    <div class="url-left" v-if="!item.show">-->
        <!--      <el-avatar shape="circle" :size="50" :src="item.url"></el-avatar>-->
        <!--    </div>-->


        <!--    <div class="name_left" v-if="!item.show">-->
        <!--      <p style="font-size: 15px;"> {{item.name}} </p>-->
        <!--    </div>-->

        <!--  </div>-->


        <!--  <div v-html="item.content"-->
        <!--       class="content_left" v-if="!item.show">-->
        <!--  </div>-->

        <!--  <div v-html="item.content"-->
        <!--       class="content_right" v-if="item.show">-->
        <!--  </div>-->

        <!--</div>-->

      </div>


      <div class=" talk-message">

        <div class="talk-message-face">
          <svg class="icon" aria-hidden="true" @click="isShow">
            <use xlink:href="#icon-biaoqing"></use>
          </svg>
          <emotion :emotionIsShow="emotionIsShow" @sendEmotionSelect="getValue"></emotion>
        </div>
        <div class="talk-message-content">

          <el-input
              v-model="text"
              resize="none"
              type="textarea"
              rows="1"
              @keyup.enter.native="submit"
              placeholder="请输入内容"
          ></el-input>
        </div>
        <div class="talk-message-send">
          <el-button type="text" style="color:#9b9b9b" @click="send">ENTER</el-button>
        </div>

      </div>

    </div>



  </el-main>
</template>

<script>
import emotion from "../layout/components/emotion.vue";
import "../assets/talk.css";
import '../utils/iconfont';
import axios from "axios";
let socket;
export default {

  components: {
    emotion
  },


  data() {
    return {
      url: "https:/rescdn.qqmail.com/node/wwopen/wwopenmng/images/qq_emotion/qq/",
      eList: ['占位', '微笑', '撇嘴', '色', '发呆', '得意', '流泪', '害羞', '闭嘴', '睡', '大哭',
        '尴尬', '发怒', '调皮', '呲牙', '惊讶', '难过', '酷', '冷汗', '抓狂', '吐', '偷笑', '可爱',
        '白眼', '傲慢', '饥饿', '困', '惊恐', '流汗', '憨笑', '大兵', '奋斗', '咒骂', '疑问', '嘘',
        '晕', '折磨', '衰', '骷髅', '敲打', '再见', '擦汗', '抠鼻', '鼓掌', '糗大了', '坏笑', '左哼哼',
        '右哼哼', '哈欠', '鄙视', '委屈', '快哭了', '阴险', '亲亲', '吓', '可怜', '菜刀', '西瓜', '啤酒',
        '篮球', '乒乓', '咖啡', '饭', '猪头', '玫瑰', '凋谢', '示爱', '爱心', '心碎', '蛋糕', '闪电', '炸弹',
        '刀', '足球', '瓢虫', '便便', '月亮', '太阳', '礼物', '拥抱', '强', '弱', '握手', '胜利', '抱拳', '勾引',
        '拳头', '差劲', '爱你', 'NO', 'OK', '爱情', '飞吻', '跳跳', '发抖', '怄火', '转圈', '磕头', '回头', '跳绳', '挥手',
        '激动', '街舞', '献吻', '左太极', '右太极'],
      contentDiv: [],
      textarea: "",
      textarea1: "",
      emotionIsShow: false, // 表情面板控制出现
      divIptEmotion: [], // 接收表情组件传过来的数据
      a: [],
      flag: true,
      show: false,
      closeChat: this.close,
      friend:{},
			user: {},
			isCollapse: false,
			users: [],
			chatUser: '',
			text: "",
			messages: [],
			content: ''
    }
  },
  created() {
    // this.friend = this.$route.params.friend;
    // console.log(this.friend)
		this.init();
    this.friend = JSON.parse(localStorage.getItem('friend'));
		this.chatUser = this.friend.username;
    console.log(this.friend);
  },
  mounted() {
    axios.get("http://localhost:9091/information/selectInformation", {
  params: {
    infSendName: this.user.username,
    infReceiveName: this.chatUser
  }
}).then(res => {
  console.log(res.data.data);

  for (let i = 0; i < res.data.data.length; i++) {

    console.log(res.data.data);
    let user = res.data.data[i];
    console.log(user.infSendName+':'+this.user.username);
    if(user.infSendName !== this.user.username) {
      this.createContent("&nbsp", null, res.data.data[i].infContent,user.infTime);

    } else{
      this.createContent(null, 1, res.data.data[i].infContent,user.infTime);

    }
  }
});

    this.scrollToBottom()
  },
  updated() {
    this.scrollToBottom()
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
					} else {
						// 如果服务器端发送过来的json数据 不包含 users 这个key，那么发送过来的就是聊天文本json数据
						//  // {"from": "zhang", "text": "hello"}
						if (data.from === _this.chatUser && data.to !== 'all') {
							_this.messages.push(data)
							// 构建消息内容
              let time = _this.getCurrentFormattedTime();
							_this.createContent(data.from, null, data.text,time)
						}
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
    getCurrentFormattedTime() {
      let now = new Date();

      function padZero(num) {
        return num < 10 ? '0' + num : num;
      }

      let year = now.getFullYear();
      let month = padZero(now.getMonth() + 1);
      let day = padZero(now.getDate());
      let hours = padZero(now.getHours());
      let minutes = padZero(now.getMinutes());
      let seconds = padZero(now.getSeconds());
      return year + "-" + month + "-" + day + " " + hours + ":" + minutes+ ":"+seconds;
    },
		createContent(remoteUser, nowUser, text,time) {  // 这个方法是用来将 json的聊天消息数据转换成 html的。
			let html
			// 当前用户消息
			if (nowUser) { // nowUser 表示是否显示当前用户发送的聊天消息，绿色气泡
				html = "<div class=\"el-row\" style=\"padding: 5px 0;display: flex;align-items: center;\">\n" +
						"  <div class=\"el-col el-col-22\" style=\"text-align: right; padding-right: 10px\">\n" +
            "    <div style=\"font-size: 9px;color: gray;margin-left: 400px\">" + time + "</div>\n" +
						"    <div class=\"tip left\" style=\"color: white;\n" +
						"\ttext-align: center;\n" +
						"\tborder-radius: 10px;\n" +
						"\tfont-family: sans-serif;\n" +
						"\tpadding: 10px;\n" +
						"\twidth: auto;\n" +
						"\tdisplay: inline-block !important;\n" +
						"\tdisplay: inline;\n" +
						"\tbackground-color: forestgreen;\">" + text + "</div>\n" +
						"  </div>\n" +
						"  <div class=\"el-col el-col-2\" style=\"text-align: left\">\n" +
						"  <span class=\"el-avatar el-avatar--circle\" style=\"height: 40px; width: 40px;\">\n" +
						"    <img src=\"https://img.pg-code-go.com\" style=\"object-fit: cover;\">\n" +
						"  </span>\n" +
						"  </div>\n" +
						"</div>";
			} else if (remoteUser) {   // remoteUser表示远程用户聊天消息，蓝色的气泡
        html = "<div class=\"el-row\" style=\"padding: 5px 0;display: flex;align-items: center;\">\n" +
            "  <div class=\"el-col el-col-2\" style=\"text-align: right\">\n" +
            "  <span class=\"el-avatar el-avatar--circle\" style=\"height: 40px; width: 40px;\">\n" +
            "    <img src=\"https://img.pg-code-go.com\" style=\"object-fit: cover;\">\n" +
            "  </span>\n" +
            "  </div>\n" +
            "  <div class=\"el-col el-col-22\" style=\"text-align: left; padding-left: 10px\">\n" +
            "    <div style=\"font-size: 10px;font-weight: bold;\">" + remoteUser + "&nbsp&nbsp<span style=\"font-size: 9px;color: gray;\">" + time + "</span></div>\n" +

            "    <div style=\"color: white !important;\n" +
            "\ttext-align: center !important;\n" +
            "\tborder-radius: 10px !important;\n" +
            "\tfont-family: sans-serif !important;\n" +
            "\tpadding: 10px !important;\n" +
            "\twidth:auto !important;\n" +
            "\tdisplay:inline-block !important;\n" +
            "\tdisplay:inline;background-color: deepskyblue;\">" + text + "</div>\n" +
            "  </div>\n" +
            "</div>";
      }
			console.log(html)
			this.content += html;
		},
		send() {
			if (!this.chatUser) {
				this.$message({type: 'warning', message: "请选择聊天对象"})
				return;
			}
			if (!this.text) {
				this.$message({type: 'warning', message: "请输入内容"})
			} else {
				if (typeof (WebSocket) == "undefined") {
					console.log("您的浏览器不支持WebSocket");
				} else {
					console.log("您的浏览器支持WebSocket");

					// 组装待发送的消息 json
					// {"from": "zhang", "to": "admin", "text": "聊天文本"}
					let message = {from: this.user.username, to: this.chatUser, text: this.text}
					socket.send(JSON.stringify(message));  // 将组装好的json发送给服务端，由服务端进行转发
          let time1 = this.getCurrentFormattedTime();
          let information = {infSendName: this.user.username, infContent: this.text,infReceiveName: this.chatUser,infTime: time1}
          axios.put('http://localhost:9091/information/insertInformation', information).then(res => {
            console.log(res)
          })
					this.messages.push({user: this.user.username, text: this.text})
					// 构建消息内容，本人消息
          let time = this.getCurrentFormattedTime();
					this.createContent(null, this.user.username, this.text,time)
					this.text = '';
				}
			}
		},

    scrollToBottom() {
      this.$nextTick(() => {
        let box = this.$el.querySelector(".talk-content")
        box.scrollTop = box.scrollHeight
      })
    },
    sendInfo() {
      alert("aaa")
    },
    isShow() {
      if (this.emotionIsShow === false) {
        this.emotionIsShow = true;
      } else {
        this.emotionIsShow = false;
      }
      // this.emotionIsShow = !this.emotionIsShow;
    },
    iptFocus() {
      this.emotionIsShow = true;
    },
    getValue(val, item) {
      let img = '<img src="' + this.url + val + '.png"  style= "width: 22px;height: 22px">';
      let el = '[' + item + ']'
      this.emotionIsShow = false;
      this.textarea = this.textarea + el;
      this.textarea1 += img;
    },
    submit() {
      let a = this.textarea;
      let pre = 0;
      let last = 0;
      let flag = false;
      while (true) {
        if (!a.match("]")) {
          break;
        }
        pre = a.indexOf("[");
        last = a.indexOf("]");

        let face = a.substring(pre + 1, last);
        let b;
        for (let j = 0; j < this.eList.length; j++) {
          if (face == this.eList[j]) {
            b = j;
            break;
          }
        }
        let img = '<img src="' + this.url + b + '.png"  style= "width: 22px;height: 22px">';
        a = a.substring(0, pre) + img + a.substring(last + 1, a.length);
        pre = 0;
        last = 0;
        flag = false;


      }

      let c = {
        "name": "锅包肉",
        "url": "https://img.pg-code-go.com/",
        "content": a,
        "show": true,
        "time": "2024-6-1 17:12:12"
      };

      let d = {
        "name": "糖醋里脊",
        "url": "https://img.pg-code-go.com/",
        "content": "沙茶桀桀桀桀桀桀桀",
        "show": false,
        "time": "2024-6-1 17:12:46"
      };

      this.textarea = "";
      this.textarea1 = "";
      this.contentDiv.push(c);
      this.contentDiv.push(d);
    },

    exit() {
      this.$emit('close',this.fleg)
    }

  },


}
</script>

<style scoped>

.tip {
	color: white;
	text-align: center;
	border-radius: 10px;
	font-family: sans-serif;
	padding: 10px;
	width:auto;
	display:inline-block !important;
	display:inline;
}

.right {
	background-color: deepskyblue;
}
.left {
	background-color: forestgreen;
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
