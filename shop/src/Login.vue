<template>
<el-card class="car-box" style="max-width: 480px">
  <el-text class="mx-1" type="warning">登录</el-text>
    <div style="margin: 20px" />
  <el-form
    :label-position="labelPosition"
    label-width="auto"
    :model="formLabelAlign"
    style="max-width: 600px"
  >
    <el-form-item label="账号">
      <el-input v-model="formLabelAlign.name" />
    </el-form-item>
    <el-form-item label="密码">
      <el-input show-password v-model="formLabelAlign.password" />
    </el-form-item>
  </el-form>
  <el-button type="primary" @click="login()">登录</el-button>
</el-card>
  
</template>
<script lang="ts" setup>
import { reactive, ref } from "vue";
import axios from 'axios'
import type { FormProps } from "element-plus";
import { useRouter } from "vue-router";
import { de } from "element-plus/es/locale";


const labelPosition = ref<FormProps["labelPosition"]>("right");

const router = useRouter()

const formLabelAlign = reactive({
  name: "",
  password: "",
});
function login(){
    axios({
        url:'/login',
        method:'get',
        params:{
            username:formLabelAlign.name,
            password:formLabelAlign.password
        }
    }).then(res => {
        console.log(res.data)
        router.push('home')
        var userInfo = res.data
        console.log(userInfo)
        localStorage.setItem('token',userInfo)
    }),err =>{
        console.log(err)
    }
}

function register(){

}

</script>
<style scoped>
.car-box{
  position: relative;
  left: 50%;
  margin-left: -240px;
  margin-top: 15%;
  text-align: center;
}
</style>