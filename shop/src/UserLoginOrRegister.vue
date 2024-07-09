<template>
  <el-tooltip content="点击切换登录注册" placement="top">
    <el-switch
      v-model="value"
      style="--el-switch-on-color: #13ce66; --el-switch-off-color: #ff4949"
      active-value="登录"
      inactive-value="注册"
      @click="change()"
    />
  </el-tooltip>
  <router-view></router-view>
</template>

<script lang="ts" setup>
import { el } from 'element-plus/es/locale';
import { reactive, ref } from 'vue'
import router from './router'
import store from './store'

const value = ref("登录")

const val = JSON.stringify(value.value)
console.log(val)
function change(){
    store.commit('increment')
    console.log(store.state.num)
    if(store.state.num%2 == 0){
      router.push({name:'login'})
      console.log(0)
    }else{
      router.push({name:'register'})
      console.log(store.state.num%2)
    }
}

</script>