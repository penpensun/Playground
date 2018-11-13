<template>
  <div>

  <p>(You can double click on an item to turn it into a folder.)</p>

  <!-- the demo root element -->
  <ul id="demo">
    <Item :model="model"></Item>
  </ul>
  <button @click="getTreeViewData">Get Tree Data</button>
  <button>Put Tree Data</button>
  </div>
</template>

<script>
import Item from '@/components/Item.vue'

export default {
  name: 'TreeView',
  components: {
    Item
  },
  data: function () {
    return {
      model: {
        name: '',
        children: []
      }
    }
  },
  methods: {
    getTreeViewData () {
      console.log('inside get tree view data')

      this.$axios.get('/rest/treeview').then(response => {
        console.log('the response')
        console.log(response)
        this.model = response.data
        console.log('the model')
        console.log(this.model)
      })
    }
  }
}
</script>
<style scoped>

</style>
