<template>
  <v-row align-center>
    <v-col >
      <v-card
        :disabled="false"
        max-width="600"
        flat class="ma-5 text-xs-center"
      >
        <form @submit.prevent="submit" ref="form">
          <v-text-field
            v-model="itemToUpdate.name"
            :counter="10"
            :error-messages="errors"
            label="Name"
            required
          ></v-text-field>
          <v-text-field
            v-model="itemToUpdate.functionn"
            :counter="7"
            :error-messages="errors"
            label="Phone Number"
            required
          ></v-text-field>
          <v-text-field
            v-model="itemToUpdate.dateOfBirth"
            :error-messages="errors"
            required>
            <v-select
              v-model="select"
              :items="items"
              :error-messages="errors"
              label="Select"
              data-vv-name="select"
              required
            ></v-select>
            <v-checkbox
              v-model="checkbox"
              :error-messages="errors"
              value="1"
              label="Option"
              type="checkbox"
              required
            ></v-checkbox>

          </v-text-field>
          <v-btn
            :disabled="invalid"
            class="mr-4"
            type="submit"
            @click="saveEdit(),clear()"
          >
            submit
          </v-btn>
          <v-btn @click="clear()">
            clear
          </v-btn>
          <v-btn
            text
     
          >
            <v-icon>mdi-chevron-left</v-icon>
        </v-btn></form>
      </v-card>
    </v-col>
  </v-row>
</template>
<script>
export default {
  props: ['sshow','itemToUpdate'],
  data: () => ({
    name: '',
    phoneNumber: '',
    email: '',
    select: null,
    items: [
      'Item 1',
      'Item 2',
      'Item 3',
      'Item 4',
    ],
    checkbox: null,
    DisableExo: true,
  }),
  computed:{
    DisableExo(){

      if(this.sshow){
        return false;
      }
      else{
        return true;
      } 
    }
  },
  mounted(){
    console.log('edit is working');
    console.log('the result of computed props', this.DisableExo);
  },
  methods: {
    submit () {
      this.$refs.observer.validate();
    },
    clear () {
       this.itemToUpdate = new Object()
      // this.$refs.form.reset();
    },

    showCard(){
      return true;
    },
  },
};
</script>