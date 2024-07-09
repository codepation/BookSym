import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import router from './router'
import axios from 'axios'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'



axios.defaults.baseURL='http://localhost:1000'
axios.defaults.timeout = 5000

const app = createApp(App)
app.use(router)
app.use(ElementPlus)
app.mount('#app')

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
  }


router.beforeEach((to,from,next)=>{
    const token = localStorage.getItem("token")
    if(to.name != 'login' && token ==null&&to.name !='register'){
        next({name:'login'})
    }else{
        next()
    }
})


