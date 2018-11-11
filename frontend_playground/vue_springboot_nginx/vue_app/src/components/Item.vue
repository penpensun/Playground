<template>
  <li>
    <div>
      {{model.name}}
    </div>
    <ul>
      <li class="item" v-for="itemValue of model.children" :key=itemValue>{{itemValue}}</li>
    </ul>
  </li>
</template>
<script>
export default {
  name: 'Item',
  props: {
    model: Object
  }
}
</script>
