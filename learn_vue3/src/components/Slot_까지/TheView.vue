<template>
	<main>
		<div class="container py-4">
			<MyButton class="my-button" id="my-button" @say-hello="sayHello">
				<!-- @click="sayHello" -->
			</MyButton>
			<LabelInput :label="'이름'" data-id="id입니다."></LabelInput>
			<hr />
			<FancyButton>Click! <span style="color: red">@@@</span></FancyButton>
			<FancyButton v-slot="{ fancyMessage }">
				{{ fancyMessage }}
			</FancyButton>
			<hr />
			<AppCard>
				<!-- <template #[slotArgs]>제목임돠!</template> -->
				<!-- <template #default>내용임돠!</template> -->
				<!-- 암시적으로 Default 스롯입니다!!
				<template v-slot:footer>푸터임돠!</template> -->
				<template #header="{ headerMessage }">
					{{ headerMessage }}
				</template>
				<template #default="{ childMessage, helloMessage }">
					디폴트이다!! {{ message }} <br />
					{{ childMessage }} <br />
					{{ helloMessage }}
				</template>
				<template #footer="{ footerMessage }">
					{{ footerMessage }}
				</template>
				<!-- {{ childMessage }} 자식 컴포넌트의 데이터는 사용못합니다. 다른 방법으로 불러와야된다.-->
			</AppCard>
			<hr />
			<AppCard> 게시글입니다.!! </AppCard>
		</div>
	</main>
</template>

<script>
import MyButton from './MyButton.vue';
import LabelInput from './LabelInput.vue';
import FancyButton from './FancyButton.vue';
import AppCard from './AppCard.vue';
import { ref } from 'vue';
export default {
	components: {
		MyButton,
		LabelInput,
		FancyButton,
		AppCard,
	},
	setup() {
		const sayHello = () => {
			alert('안녕!!!!');
		};

		const slotArgs = ref('header');
		const message = ref('상위 컴포넌트만 데이터를 이용할 수 있습니다.');
		return {
			sayHello,
			slotArgs,
			message,
		};
	},
};
</script>

<style lang="scss" scoped></style>
