<template>
    <el-button @click="oppenaddbook(),state.addOrupdate = 'add',dialogTableVisible=true" type="success" round>add book</el-button>
  <el-table :data="state.form" style="width: 100%">
    <el-table-column fixed prop="bookId" label="id" width="150" />
    <el-table-column prop="bookName" label="Name" width="120" />
    <el-table-column prop="bookIsbn" label="isbn" width="120" />
    <el-table-column prop="bookPress" label="press" width="120" />
    <el-table-column prop="bookAuthor" label="Author" width="120" />
    <el-table-column prop="bookPrice" label="price" width="120" />
    <el-table-column fixed="right" label="Operations" min-width="120">
      <template #default="scope">
        <el-button link type="primary" size="small" @click="state.addOrupdate ='update',handleClick(scope.row),dialogTableVisible = true">
          alter
        </el-button>
        <el-button @click="deleteBook(scope.row)" link type="primary" size="small">delete</el-button>
      </template>
    </el-table-column>
  </el-table>

  <el-dialog v-model="dialogTableVisible" title="Shipping address" width="800">
    <el-form :model="forms">
        <el-form-item v-if="state.addOrupdate == 'add'">
          
        </el-form-item>
        <el-form-item v-else label="书本ID" :label-width="formLabelWidth">
          <el-input v-model="forms.bookId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="书名" :label-width="formLabelWidth">
          <el-input v-model="forms.bookName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="出版社" :label-width="formLabelWidth">
          <el-input v-model="forms.bookPress" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="书本isbn号" :label-width="formLabelWidth">
          <el-input v-model="forms.bookIsbn" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="作者" :label-width="formLabelWidth">
          <el-input v-model="forms.bookAuthor" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="价格" :label-width="formLabelWidth">
          <el-input v-model="forms.bookPrice" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <el-button v-if="state.addOrupdate == 'update'" @click="updataBook(),dialogTableVisible=false" type="success" round>update book</el-button>
      <el-button v-else type="success" @click="addbook(),dialogTableVisible=false" round>uplaod book</el-button>
  </el-dialog>
</template>

<script lang="ts" setup>

import axios from "axios"
import { onMounted, reactive, ref } from "vue"


function getbook(){
    axios({
        url:'/book/getbook',
        method:'GET'
    }).then(res =>{
        state.form = res.data
        console.log(res.data)
        console.log(state.form)
    }).catch(err =>{
        console.log(err)
    });
}

onMounted(()=>{
    getbook()
})

function handleClick(row){
    this.forms = JSON.parse(JSON.stringify(row))
    //this.$forceUpdate()
    console.log()
    console.log(state.addOrupdate)
}
function oppenaddbook(){
    this.forms = {
        bookId: "",
        bookName: "",
        bookPress: "",
        bookAuthor: "",
        bookPrice: "",
        bookIsbn: "",
    }
}
function addbook(){ 
    console.log(this.forms)
    axios({
        url:'/book/addbook',
        method:'POST',
        data:forms
    }).then(res =>{
        console.log(res.data)
        console.log(forms)
        alert(res.data)
        getbook()
    }).catch(err =>{
        console.log(err)
    });
}
function deleteBook(row){
    axios({
        url:'/book/deleteBook/'+row.bookId,
        method:'DELETE'
    }).then(res =>{
        alert(res.data)
        getbook()
    }).catch(err =>{
        console.log(err)
    });  
}
function updataBook(){
    console.log(this.forms)
    axios({
        url:'/book/updatebook',
        method:'PUT',
        data:this.forms
    }).then(res=>{
        alert(res.data)
        getbook()
    }).catch(err=>{
        console.log(err)
    })
}

const state = reactive({
    form:[
        {
            bookId: "",
            bookName: "",
            bookPress: "",
            bookAuthor: "",
            bookPrice: "",
            bookIsbn: "",
        }
    ],
    addOrupdate:''
})
const forms =ref(
    {
    bookId: "",
    bookName: "",
    bookPress: "",
    bookAuthor: "",
    bookPrice: "",
    bookIsbn: "",
}
) 

const dialogTableVisible = ref(false)
</script>



