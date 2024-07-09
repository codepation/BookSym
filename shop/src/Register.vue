<template>
  <el-card class="car-box" style="max-width: 480px">
    <div class="text">
      <el-text class="mx-1" type="warning">注册</el-text>
    </div>

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
      <el-form-item label="确认密码">
        <el-input
          type="password"
          show-password
          v-model="formLabelAlign.configPassword"
        />
      </el-form-item>
    </el-form>
    <el-button type="primary" @click="register()">注册</el-button>
  </el-card>
</template>
<script lang="ts" setup>
import { reactive, ref } from "vue";
import axios from "axios";
import type { FormProps } from "element-plus";
import { useRouter } from "vue-router";
import { de } from "element-plus/es/locale";

const labelPosition = ref<FormProps["labelPosition"]>("right");

const router = useRouter();

const formLabelAlign = reactive({
  name: "",
  password: "",
  configPassword: "",
});
function register() {
  if (formLabelAlign.password == formLabelAlign.configPassword) {
    axios({
      url: "/user/register",
      method: "POST",
      params: {
        username: formLabelAlign.name,
        password: formLabelAlign.configPassword,
      },
    })
      .then((res) => {
        if (res.data == "账号已经注册") {
          alert("账号已注册");
        } else {
          if (res.data == "sussecc") {
            router.push("home");
            var userInfo = res.data;
            console.log(userInfo);
            localStorage.setItem("token", userInfo);
          } else {
            alert("注册失败");
          }
        }
      })
      .catch((err) => {
        console.log(err);
      });
  } else {
    alert("密码不一样");
  }
}
</script>
<style scoped>
.car-box {
  position: relative;
  left: 50%;
  margin-left: -240px;
  margin-top: 15%;
  text-align: center;
}
</style>