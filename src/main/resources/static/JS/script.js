console.log("connected");
const images = ["../Images/bg1_home.png", "../Images/bg2_home.png", "../Images/bg3_home.png", "../Images/bg2_home.png"];
let index = 0;

function changeMockupImage() {
	const mockupImage = document.getElementById("mockup-image");
	mockupImage.src = images[index];
	index = (index + 1) % images.length;
}


const searchFocus = document.getElementById('search-focus');
const keys = [
	{ keyCode: 'AltLeft', isTriggered: false },
	{ keyCode: 'ControlLeft', isTriggered: false },
];





