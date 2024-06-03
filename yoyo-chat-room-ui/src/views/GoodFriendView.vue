<template>
  <div>
    <el-container class="container_style">
      <!--    侧二边-->

        <el-menu class="asideTwo_Style" router>
          <el-input class="el-input1_style"
              placeholder="寻找或开始新的对话"
              prefix-icon="el-icon-search"
              v-model="input1">
          </el-input>
          <el-menu-item index="/songoodfriend">
<!--            <router-link to="/songoodfriend">-->
              <img src="../assets/好友.png" class="set_image">
              <span slot="title" class="span_Style">好友</span>
<!--            </router-link>-->
          </el-menu-item>

          <el-menu-item index="/community">
            <img src="../assets/社区.png" class="set_image">
            <span slot="title" class="span_Style">社区</span>
          </el-menu-item>

          <el-divider content-position="left">聊天</el-divider>
          <el-menu-item index="2" aria-selected="true" disabled>
            <span slot="title" class="span_Style" content-position="left"># 欢乐社区</span>
            <img src="../assets/表情.png" align="middle" width="20vh" height="20vh">
          </el-menu-item>

          <div style="padding-top: 50vh">
            <img src="../assets/男人像-1.png" class="set_image">
            <footer style="color: #9a9999">彭刚</footer>
            <footer style="color: #9a9999">hhhhhhhh</footer>
            <el-button icon="el-icon-mic" circle></el-button>
            <el-button icon="el-icon-service" circle></el-button>
          </div>

        </el-menu>



      
      <el-container>

<!--        <el-header>-->
<!--          <img src="../assets/表情.png" align="middle" width="40" height="40">-->
<!--            <span class="span_header_Style">欢乐社区</span>-->
<!--        </el-header>-->
        <!--header-->
        <el-main>

          <router-view/>

        </el-main>
<!--        <div class="foot_Style">-->
<!--          <el-input v-model="input2" placeholder="请输入内容" ></el-input>-->
<!--          <el-button class="el-button_style" type="submit">ENTER</el-button>-->
<!--        </div>-->
      </el-container>
    </el-container>
  </div>
</template>

<script>

export default {
  name: "GoodFriendView",
  data() {
    return {
      isCollapse: true,
      input1: '',
      input2: '',
      size: ''
    };
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}

</script>

<style scoped>

.container_style{
  /*border: 2px red solid;*/
  padding: 0;
  margin: 0;
}
.asideTwo_Style {
  /*background-color: #363535;*/
  background-color: rgb(211,183,216);
  height: 100vh;
  width: 30vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  /*border: 2px red solid;*/
}


.set_image{
  padding-top: 1vh;
  width: 2vw;
  height: 3vh;
}

.span_Style{
  /*border: 1px solid red;*/
  color: #9a9999;
  /*border: 2px red solid;*/
}

/*.three_index_Style{*/
/*  */
/*  border: 1px red solid;*/
/*  color: #9a9999;*/
/*}*/
.span_header_Style{
  color: #fff;
}

/*.foot_Style {*/
/*  width: 100%;*/
/*  display: flex;*/
/*  border-radius: 100px !important;*/
/*  overflow: hidden;*/
/*  border: 5px solid #7c8f7c;*/
/*  padding: 0 !important;*/
/*}*/


/*.el-header {*/
/*  border-bottom: 1px #000 solid;*/
/*  background-color: #565657;*/
/*  color: #333;*/
/*  text-align: center;*/
/*  line-height: 60px;*/
/*}*/

.el-main {
  align-self: auto;
  /*background-color: #565657;*/
  background-color: rgb(245,234,248);
  color: #333;
  text-align: center;
  height: 100vh;
  padding: 0 !important;
  /*border: 2px solid red;*/
}
.el-input1_style{
  margin-top: 1vh;
  /*border: 2px red solid;*/
  /*!*padding: 0 !important;*!*/
  /*!*margin: 0 !important;*!*/
  width: 15vw;
}
.el-menu-item{
  /*border: 2px red solid;*/
  border-radius: 20px;
}  .el-menu-item:hover{
  background-color: #fff;
}

/*.el-button_style{*/
/*  height: 40px;*/
/*}*/

</style>