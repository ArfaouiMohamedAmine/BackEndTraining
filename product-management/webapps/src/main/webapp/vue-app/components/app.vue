
<template>
  <v-app
    id="vuetify_webpack_sample"
    color="transaprent"
    class="VuetifyApp"
    flat>
    <main >
      <v-btn
        color="pink"
        dark
        @click="open(),getAllData()"
      >
        Open 
      </v-btn>
      <exo-drawer
        id="activityKudosDrawer"
        ref="testDrawer"
        width="500px"
        hide-actions
        right
        disable-pull-to-refresh>
        <template slot="title">
          <v-btn class="text-header-title" @click="close()">
            Add Exoer 
          </v-btn>
        </template>
        <template slot="content">
          <v-row>
            <v-col
              v-for="item in items"
              :key="item.id"
            >

              <v-list-item>
                <v-list-item-avatar color="grey"/>
                <v-list-item-content>
                  <v-list-item-title class="headline">{{ item.name }}</v-list-item-title>
                  <v-list-item> {{ item.functionn }} DT</v-list-item>
                  <v-list-item> {{ item.dateOfBirths }} </v-list-item>
                </v-list-item-content>
              </v-list-item>

        
            </v-col>
          </v-row>
        </template>
      </exo-drawer>
      <v-form>
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
          <v-btn
            @click="checkForm()"
          >Envoyer</v-btn>
        </v-container>
      </v-form>
  
      
    
    </main>
  </v-app>
</template>
<script>
import axios from 'axios';

export default {
  name:'FirsPage',
  data: function() {
    return {
      errors: [],
      datas  : {},
      items: [],
      name : null , 
      functionn : null , 
      dateOfBirth : null  ,

    };
  },
  computed: {
    kudosReceiver () {
      return {
        receiverId: this.kudosToSend && this.kudosToSend.id,
        avatar: this.kudosToSend && this.kudosToSend.avatar,
        profileUrl: this.kudosToSend && this.kudosToSend.profileUrl,
        fullName: this.kudosToSend && this.kudosToSend.receiverFullName
      };
    }
  },
  
  mounted () {
    axios
      .get('http://localhost:8080/portal/rest/v1/exoers')
      .then(response => {
        this.items = response.data;
      });
    this.$refs.testDrawer.drawer = false ; 
  },
  methods:{
    getAllData(){    axios
      .get('http://localhost:8080/portal/rest/v1/exoers')
      .then(response => {
        this.items = response.data;
      });},
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
    open()
    {
      
      this.$refs.testDrawer.open();
    },
    close()
    {
      
      this.$refs.testDrawer.close();
    }
  }
};
</script>
