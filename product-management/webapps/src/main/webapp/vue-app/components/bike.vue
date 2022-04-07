     
<template>
    

  <v-row>
    <v-col
      v-for="item in bikes"
      :key="item.id"
    >
      <v-img
        height="250"
       
      ></v-img>

      <v-card-title>{{ item.color }}</v-card-title>

      <v-card-text>
        <v-row
          align="center"
          class="mx-0"
        >
          <v-rating
            :value="4.5"
            color="amber"
            dense
            half-increments
            readonly
            size="14"
          ></v-rating>


          <div>{{ item.engineSize }}</div>
      </v-row></v-card-text>

      <v-divider class="mx-4"></v-divider>

      <v-card-title>{{ item.bikeDesc }}</v-card-title>

  </v-col></v-row>
</template>
<script>
import axios from 'axios';
export default {
  name:'SecondPage',
  data: function(){
    return {
      errors: [],
      datas  : {},
      items: [],
      engineSize : null , 
      color : null , 
      img : null  ,
      bikeDesc : null  ,
      circulationNmber : null ,
    };
  },
  mounted(){
    axios
      .get('http://localhost:8080/portal/rest/v1/bikes')
      .then(response => {
        this.bikes = response.data;
      });
    this.$refs.testDrawer.drawer = false ; 
  },
  methods:{

    getAllBikes(){    axios
      .get('http://localhost:8080/portal/rest/v1/bikes')
      .then(response => {
        this.bikes = response.data;
      });},

    checkForm() {
      const bikes  = { 
        engineSize: this.engineSize , 
        color : this.color , 
        img: this.img,
        bikeDesc: this.bikeDesc,
        circulationNmber: this.circulationNmber,
      };
      axios.post('http://localhost:8080/portal/rest/v1/bikes', bikes)
      ;
    },
  }
};
</script>