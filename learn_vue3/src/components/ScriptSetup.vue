<template>
	<div class="container py-4">
		{{ msg }}
		<br />
		{{ message }}
		<input v-model="message" type="text" />
		<button @click="sayHello">Click</button>
		<PostItem
			type="news"
			title="제목"
			contents="내용"
			:is-like="true"
		></PostItem>
		<PostItem
			type="news"
			title="제목"
			contents="내용"
			:is-like="true"
		></PostItem>
		<PostItem
			type="news"
			title="제목"
			contents="내용"
			:is-like="true"
		></PostItem>
		<hr />
		<TemplateRefsChild ref="child"></TemplateRefsChild>
		<template v-if="child">{{ child.message }}</template>
		<hr />
		<MyButton class="parent-class"></MyButton>
	</div>
</template>

<script setup>
import TemplateRefsChild from './Setup/TemplateRefsChild.vue';
import PostItem from './Setup/PostItem.vue';
import MyButton from './Setup/MyButton.vue';
import axios from 'axios';
import { ref } from 'vue';

const msg = 'Hello mama';
const message = ref('');
const sayHello = () => {
	alert('Hello World@@@@');
};
const child = ref(null);
defineExpose({
	msg,
});

const reponse = await axios(
	'https://dummy.restapiexample.com/api/v1/employees',
);
console.log('response: ', reponse);
</script>

<style lang="scss" scoped></style>
