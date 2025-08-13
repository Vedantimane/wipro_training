

const images = ["img1.jpeg", "img2.jpeg", "img3.jpeg","img4.jpeg"];
let currentIndex = 0;

const galleryImage = document.getElementById("galleryImage");

function nextImage() {
    if (currentIndex >= images.length) {
        currentIndex = 0;
    } else {
        currentIndex++;
    }
    galleryImage.src = images[currentIndex];
}

function prevImage() {
    if (currentIndex < 0) {
        currentIndex = images.length - 1;
    } else {
        currentIndex--;
    }
    galleryImage.src = images[currentIndex];
}
