<template>
 
  <form @submit.prevent="submit">
    <v-text-field
      v-model="name"
      :counter="10"
      :error-messages="errors"
      label="Name"
      required
    ></v-text-field>
    <v-text-field
      v-model="phoneNumber"
      :counter="7"
      :error-messages="errors"
      label="Phone Number"
      required
    ></v-text-field>
    <v-text-field
      v-model="email"
      :error-messages="errors"
      label="E-mail"
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
    <v-btn>
      clear
  </v-btn></form>
</template>
<script>
export default {
  props:{saveEditBool : {
    type: Boolean,
    default: true
  }},
  emits:['saveEditBool'],
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
  }),
  mounted(){
    console.log('edit is working');
  },

  methods: {
    submit () {
      this.$refs.observer.validate();
    },
    clear () {
      this.name = '';
      this.phoneNumber = '';
      this.email = '';
    },
    saveEdit(){
      this.saveEditBool =!this.saveEditBool;
      this.$emit(this.saveEditBool);
      console.log(`edit${  this.saveEditBool}`);
    }
  },
};
</script>