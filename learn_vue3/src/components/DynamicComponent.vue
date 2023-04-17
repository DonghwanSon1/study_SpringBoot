<template>
	<div class="container py-4">
		<button class="btn btn-primary" @click="changeCurrentComp(DynamicApple)">
			사과
		</button>
		<button class="btn btn-danger" @click="changeCurrentComp(DynamicBanana)">
			바나나
		</button>
		<hr />
		<component :is="currentComp"></component>
		<p>{{ obj1 }}</p>
		<p>{{ obj2 }}</p>
	</div>
</template>

<script setup>
import { ref, shallowRef } from 'vue';
import DynamicApple from './DynamicApple.vue';
import DynamicBanana from './DynamicBanana.vue';

// const currentComp = ref(DynamicApple); ref보다 shallowRef로 하는게 퍼포먼스적으로 더 효율적이다.
const currentComp = shallowRef(DynamicApple);
const obj2 = shallowRef({ name: '김길동' }); // shallowRef는 name은 변경이 반응적으로 안되고, 전체 변경은 된다. 즉, 값 자체가 변경되어야 변경이 된다.
const obj1 = ref({ name: '홍길동' }); // Ref는 당연히 반응적으로 둘다 변경이 된다.
const changeCurrentComp = comp => (currentComp.value = comp);
</script>

<style lang="scss" scoped></style>
