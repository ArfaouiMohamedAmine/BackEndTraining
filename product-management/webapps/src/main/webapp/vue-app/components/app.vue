
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
        @click="open()"
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
          <span class="text-header-title">
            Add Exoer 
          </span>
        </template>
        <template slot="content">
          content 
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
              <v-textarea
                v-model="functionn"
                color="teal"
              >
              </v-textarea>
            </v-col>
            <v-col>   <v-date-picker v-model="dateOfBirth" :landscape="true" :reactive="true"></v-date-picker></v-col>
          </v-row>
          <v-btn
            @click="checkForm()"
          >Envoyer</v-btn>
        </v-container>
      </v-form>
  
      <v-row>
        <v-col
          v-for="item in items['exoer']"
          :key="item.id"
        >
          <v-card 
            id="vuetify_webpack_sample"
            max-width="344"
            
            class="mx-auto my-2  v-col">
            <v-list-item>
              <v-list-item-avatar color="grey"/>
              <v-list-item-content>
                <v-list-item-title class="headline">{{ item.name }}</v-list-item-title>
                <v-list-item-subtitle> {{ item.functionn }} DT</v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>
            <v-card-text >
              {{ item.functionn }}
            </v-card-text>
    
            <v-card-actions>
              
              <v-dialog
                v-model="dialog"
                transition="dialog-top-transition"
                max-width="600"
              >
                <template v-slot:activator="{ on, attrs }">
                  <v-btn
                    v-bind="attrs"
                    color="primary"
                    v-on="on"
                    @click="details(item)"
                    
                  >
                    Detail</v-btn>
                </template>
                <template v-slot:default="dialog">
                  <v-card>
                    <v-toolbar
                      color="primary"
                      dark
                    >{{ datas.title }}</v-toolbar>
                    <v-card-text>
                      <div class="text-h4 pa-12">{{ datas.functionn }}</div>
                    </v-card-text>
                    <v-card-actions class="justify-end">
                      <v-btn
                        text
                        @click="dialog.value = false"
                      >Close</v-btn>
                    </v-card-actions>
                  </v-card>
                </template>
              </v-dialog>
              <v-btn
                text
                color="deep-purple accent-4">
                Bookmark
              </v-btn>
              <div class="flex-grow-1"></div>
              <v-btn icon>
                <v-icon>mdi-heart</v-icon>
              </v-btn>
              <v-btn icon>
                <v-icon>mdi-share-variant</v-icon>
              </v-btn>
            </v-card-actions>
          </v-card>
        
        </v-col>
      </v-row>
    
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
    details(item)
    {
      this.datas = item ; 
    },
    checkForm() {
      const product  = {
        id : 1 , 
        name: this.name , 
        dateOfBirth: this.dateOfBirth,
        functionn : this.functionn , 
      };
      axios.post('http://localhost:8080/portal/rest/v1/exoers', product)
        .then(response => this.isAdded = response.data);
    },
    open()
    {
      this.$refs.testDrawer.open();
    }
  }
};
</script>
