
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
            Add product 
          </span>
        </template>
        <template slot="content">
          <v-form ref="form" @submit.prevent >
            <v-container>
              <v-row>
                <v-col
                  cols="6" 
                
                  md="12"
                >
                  <v-text-field
                    v-model="name"
                    :rules="nameRules"
               
                    label="name product"
                    required
                  ></v-text-field>
                </v-col>

                <v-col cols="6" md="12">
                  <v-textarea
                    v-model="description"
                    color="teal"
                  >
                    <template v-slot:label>
                      <div>
                        Bio <small>(optional)</small>
                      </div>
                    </template>
                  </v-textarea>
                </v-col>
        
         
              </v-row>
              <v-row>
                <v-col cols="1" md="12">
                  <v-text-field
                    v-model="price"
                    label="Price"
                    prefix="DT"

                  ></v-text-field>
              
                </v-col>
                <v-col cols="6" md="12">
                  <v-file-input
                    v-model="image"
                    counter
                    show-size
                    truncate-length="15"
                  ></v-file-input>
                </v-col>
              </v-row>
              <div
                @click="submit"
              >Envoyer</div>
            </v-container>
          </v-form>
        </template>
      </exo-drawer>
      <v-row>
        <v-col
          v-for="item in items"
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
                <v-list-item-subtitle> {{ item.price }} DT</v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>
    
            <v-img
              :src="'https://www.akamai.com/content/dam/site/im-demo/'+ item.img"
              height="194"/>
    
            <v-card-text >
              {{ item.description }}
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
                      <div class="text-h4 pa-12">{{ datas.description }}</div>
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
                color="deep-purple accent-4"
                @click="deleteProduct(item.id)" >
                Delete 
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
      description : null , 
      price : null  ,
      image : null ,
      isAdded : null
    };
  },
  computed: {},
  mounted () {
    axios
      .get('http://localhost:8080/portal/rest/v1/products')
      .then(response => {
        this.items = response.data;
      });
    this.$refs.testDrawer.drawer = false ; 
  },
  methods:{

    deleteProduct(id){
      axios.post(`http://localhost:8080/portal/rest/v1/products/deleteProduct/${id}`)
        .then(res => {
          this.items = res ; 
          axios
            .get('http://localhost:8080/portal/rest/v1/products')
            .then(response => {
              this.items = response.data;
            });
        }); 
    },
    details(item)
    {
      this.datas = item ; 
    },
    open()
    {
      this.$refs.testDrawer.open();
    },
    refresh(){
      axios
        .get('http://localhost:8080/portal/rest/v1/products')
        .then(response => {
          this.items = response.data;
        });
      this.$refs.testDrawer.drawer = false  ; 
      this.$refs.form.reset();
    },
    submit(){
      const product  = {
        name: this.name , 
        price : this.price , 
        description : this.description , 
        img : 'perceptual-standard.jpg'
      };
      axios.post('http://localhost:8080/portal/rest/v1/products', product)
        .then(response => {
          this.items = response.data ; 
          this.refresh();
        }); 
    }
  }
};
</script>
