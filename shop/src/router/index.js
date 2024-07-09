import { createRouter, createWebHashHistory, createWebHistory } from "vue-router";

const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: '/',
            redirect: '/home'
        },

        {
            path: '/home',
            name: 'home',
            component: () => import('../Home.vue'),
            children: [
                {
                    path: '/hello',
                    name: 'hello',
                    component: () => import('../components/hello.vue'),
                },
                {
                    
                    path: '/text',
                    name: 'text',
                    component: () => import('../components/text.vue')
                
                }
    ]
},

    {
        path: '/logOrreg',
        name: "logOrreg",
        component: () => import('../UserLoginOrRegister.vue'),
        children: [
            {
                path: '/login',
                name: 'login',
                component: () => import('../Login.vue'),
            },
            {
                path: '/register',
                name: 'register',
                component: () => import('../Register.vue')
            },
        ]
    },
        

    ]
})
export default router