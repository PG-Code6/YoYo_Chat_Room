<template>
<div>
  <el-header>
    <div style="display: flex;align-items: center;">
    <img src="../assets/表情.png" align="middle" width="40vh" height="40vh">
    <span class="span_header_Style">好友列表</span>
    </div>
  </el-header>

  <el-main>

    <div  class="Dynamic">
      <button class="Dynamic2" @click="openNewWindow(item)" v-for="(item,index) in friends" :key="index">
        <img :src="item.avatar" class="avatar">
        <div class="Dynamic">
          <span class="friendtext">{{item.name}}</span>
          <span class="friendtext2">{{item.sign}}</span>
          <span class="friendtext">{{item.sign_content}}</span>
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
      ]
    };
  },
  methods: {
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
  float:left;
  display: flex;
  flex-direction: row;
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
  background-color: rgb(255,255,255);
}

.friendtext{
  font-size: 20px;
  color:white;
  text-align: left;
  margin-top: 10px;
  margin-bottom: 10px;
  width: 65vw;
  /*  border: 1px solid #ff0000;*/
  overflow-wrap: break-word;
}
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
  border-bottom: 1px #605f5f solid;
}
</style>
