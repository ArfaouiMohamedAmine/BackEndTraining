import app from './components/empty.vue';

new Vue({
  render:h=> h(app)
}).$mount('#emptyApp');

extensionRegistry.registerComponent('ActivityFooter','activity-footer-action',{
  id:'Relikes',
  vueComponent: Vue.options.components['activity-like-action'],
  rank:80,
});