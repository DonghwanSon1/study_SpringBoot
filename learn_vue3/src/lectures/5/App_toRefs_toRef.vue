<template>
	<div>
		<p>author: {{ author }}</p>
		<p>title: {{ title }}</p>
	</div>
</template>

<script>
import { reactive, toRef } from 'vue';

export default {
	setup() {
		const book = reactive({
			author: 'Vue Team',
			year: '2020',
			title: 'Vue 3 Guide',
			description: '당신은 지금 바로 이 책을 읽습니다. :)',
			price: '무료',
		});
		// const { author, title } = book;
		// console.log(typeof author);
		// console.log(typeof book);
		// 위에처럼 했을 시 반응형을 잃어 버린다. -> string이다.
		// 따라서 반응형을 않잃어버리게 하려면 toRefs를 사용해야된다.

		// const { author, title } = toRefs(book); -> 두개 이상 가져오고 싶을때!
		const author = toRef(book, 'author');
		const title = toRef(book, 'title');

		return {
			author,
			title,
			book,
		};
	},
};
</script>

<style lang="scss" scoped></style>
