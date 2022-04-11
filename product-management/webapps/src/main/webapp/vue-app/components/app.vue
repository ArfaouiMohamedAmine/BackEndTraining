
<template>
  <v-app
    id="vuetify_webpack_sample"
    color="transaprent"
    class="VuetifyApp"
    flat>
    <main >
      <exo-drawer
        id="activityKudosDrawer"
        ref="testDrawer"
        hide-actions
        right
        disable-pull-to-refresh>
        <template slot="title">
          <div class="mx-2"></div>
          <v-btn color="red lighten-1" rounded>
            <v-icon>mdi-cached</v-icon>
          </v-btn>    
          <v-btn class="text-header-title" @click="close()">
            Add Exoer 
          </v-btn>
          <v-col
            cols="12"
            sm="6"
            md="3"
          >
            <v-text-field
              v-model="searchTf"
              label="Solo"
              placeholder="Search"
              solo
            ></v-text-field>
        </v-col></template>
        <template slot="content">
          <v-row v-for="item in items"
                 :key="item.id">
            <v-list-item>
              <v-list-item-avatar/>
              <v-list-item-content>
                <v-list-item-title class="headline">{{ item.name }}</v-list-item-title>
                <v-list-item class="headline">{{ item.id }}</v-list-item>
                <v-row
                  align="center"
                  justify="center"
                >
                  <div class="mx-2"></div>
                  <v-icon></v-icon>
                  <div class="mx-2"></div>
                  <v-btn
                    color="red lighten-1"
                    depressed
                    @click="deleteExoer(item.id)"
                  >
                    <v-icon left>
                      mdi-cancel
                    </v-icon>
                    Delete
                  </v-btn>
                  <div class="mx-2"></div>
                  <v-btn
                    color="red lighten-1"
                    depressed
                    @click="saveEdit(item)"
                  >
                    <v-icon left>
                      mdi-edit
                    </v-icon>
                    Update
                  </v-btn>
                </v-row>
               
              </v-list-item-content>
            </v-list-item>
          </v-row>
           <v-row  >
                  <EditPop v-show="saveEditBool" ref="childC" 
                           :save-edit-bool="false" :itemToUpdate="itemToUpdate"/>    
                </v-row>
        </template>
      </exo-drawer>
      <v-form >
        <v-container>
          <v-row>
            <v-col
              cols="6"
              md="4"
            >
              <v-text-field
                v-model="name"
                :rules="nameRules"  
                label="name exoer"
                required
              ></v-text-field>
            </v-col>
            <v-col cols="6">
              <v-text-field
                v-model="functionn"
                color="teal"
              >
              </v-text-field>
            </v-col>
            <v-col><v-text-field v-model="dateOfBirth"></v-text-field></v-col>
          </v-row>
          <div class="my-2">
            <v-btn
              color="success"
              fab
              x-large
              dark
              @click="open(),getAllData()"
            >
              <v-icon>mdi-account-circle</v-icon>
            </v-btn>
          </div>
          <div class="my-2">
            <v-btn
              color="success"
              fab
              x-large
              dark
              @click="checkForm()"
            >
              <v-icon>mdi-domain</v-icon>
            </v-btn>
          </div>
        </v-container>
      </v-form>
    </main>
    <v-row>
      <v-col>
      </v-col>
    </v-row>
  </v-app>
</template>
<script>
import axios from 'axios';
import EditPop from './edit.vue';
export default {
  name:'FirsPage',
  components: { EditPop },
  data: function() {
    return {
      itemToUpdate:{},
      errors: [],
      datas  : {},
      items: [],
      idEx: null,
      name : null , 
      functionn : null , 
      getSaveBool:false,
      searchTf: '',
      sshow : true,
      saveEditBool : false,
      OnlyThisOne: false,
    };
  },

  watch:{
    searchTf(newVal,oldVal){
      this.getOneData(newVal);
      console.log('oldVal',oldVal);
    }
  },
  methods:{
    getAllData(){    axios
      .get('http://localhost:8080/portal/rest/v1/exoers')
      .then(response => {
        this.items = response.data;
      });},
    getOneData(id){    axios
      .get(`http://localhost:8080/portal/rest/v1/exoers/getOneExoerById/${id}`)
      .then(response => {
        this.items = response.data;
      });
    console.log(id);
    },
    details(item)
    {
      this.datas = item ; 
    },
    checkForm() {
      const exoer  = { 
        name: this.name , 
        functionn : this.functionn , 
        dateOfBirth: this.dateOfBirth,

      };
      axios.post('http://localhost:8080/portal/rest/v1/exoers', exoer)
      ;
    },

    deleteExoer(idEx){
      console.log('xxxxxxxxxxxxxxxxxxxxxxxxxxxxx');
      console.log(idEx);
      console.log('xxxxxxxxxxxxxxxxxxxxxxxxxxxxx');
      axios.post(`http://localhost:8080/portal/rest/v1/exoers/deleteExoers/${idEx}`);
      this.$refs.testDrawer.close();
    },

    open()
    {
      this.$refs.testDrawer.open();
    },
    close()
    {
      this.$refs.testDrawer.close();
    },
    saveEdit(item){
      this.saveEditBool =!this.saveEditBool;
      this.itemToUpdate = Object.assign({},item) ;
    },
  }
};
</script>
