function redirectToSearch1() {
    const searchKeyword = document.getElementById('searchKeyword1').value.trim();
    let query = '';

    // Determine the search query
    if (searchKeyword === '아우터') {
        query = 'search_outer.html';
    } else if (searchKeyword === '탑') {
        query = 'search_top.html';
    } else if (searchKeyword === '스커트') {
        query = 'search_skirt.html';
    } else if (searchKeyword === '팬츠') {
        query = 'search_pants.html';
    } else if (searchKeyword === '원피스') {
        query = 'search_onepiece.html';
    } else {
        // Show error message
        document.getElementById('errorMessage1').textContent = '검색어가 카테고리에 없습니다. 카테고리 중 하나를 선택해주세요.';
        return;
    }

    // Redirect to the search results page
    window.location.href = query;
}

function handleSearch() {
    const searchKeyword = document.getElementById('searchKeyword2').value.trim();
    let query = '';

    // Show error message and return if search keyword is empty
    if (!searchKeyword) {
        document.getElementById('errorMessage2').textContent = ''; // 에러 메시지 숨기기
        return;
    }

    // Determine the search query
    if (searchKeyword === '아우터') {
        query = 'search_outer.html';
    } else if (searchKeyword === '탑') {
        query = 'search_top.html';
    } else if (searchKeyword === '스커트') {
        query = 'search_skirt.html';
    } else if (searchKeyword === '팬츠') {
        query = 'search_pants.html';
    } else if (searchKeyword === '원피스') {
        query = 'search_onepiece.html';
    } else {
        // Show error message and return if search keyword is not in categories
        document.getElementById('errorMessage2').textContent = '검색어가 카테고리에 없습니다. 카테고리 중 하나를 선택해주세요.';
        return;
    }

    // Hide error message if search keyword is valid
    document.getElementById('errorMessage2').textContent = '';

    // Save the search keyword to the recent searches and redirect to search results page
    saveAndRedirect(searchKeyword, query);
}

document.getElementById('searchKeyword1').addEventListener('input', function () {
    const errorMessage = document.getElementById('errorMessage1');
    const searchKeyword = this.value.trim();

    // Hide error message if the input field is empty
    if (!searchKeyword) {
        errorMessage.textContent = '';
    }
});

document.getElementById("mysc").addEventListener("click", function(event) {
    event.preventDefault();
    window.scrollBy({
        top: 1120,
        left: 0,
        behavior: 'smooth'
    });
});

document.getElementById('searchKeyword2').addEventListener('input', function () {
    const errorMessage = document.getElementById('errorMessage2');
    const searchKeyword = this.value.trim();

    // Hide error message if the input field is empty
    if (!searchKeyword) {
        errorMessage.textContent = '';
    }
});
// Function to save the search keyword to recent searches and redirect to the search results page
function saveAndRedirect(searchKeyword, query) {
    // Get the recent searches from cookies or initialize an empty array
    const recentSearches = getCookie('recentSearches') ? JSON.parse(getCookie('recentSearches')) : [];

    // Add the current search keyword to the beginning of the recent searches array
    recentSearches.unshift(searchKeyword);

    // Keep only the latest 5 searches
    const uniqueRecentSearches = [...new Set(recentSearches)].slice(0, 5);

    // Update the recent searches in the cookies
    setCookie('recentSearches', JSON.stringify(uniqueRecentSearches));

    // Redirect to the search results page
    window.location.href = query;
}

// Function to set a cookie with the given name and value
function setCookie(name, value) {
    document.cookie = `${name}=${value}; path=/`;
}

// Function to get the value of a cookie with the given name
function getCookie(name) {
    const cookieValue = document.cookie.match(`(^|;)\\s*${name}\\s*=\\s*([^;]+)`);
    return cookieValue ? cookieValue.pop() : null;
}

// Function to delete a cookie with the given name
function deleteCookie(name) {
    document.cookie = `${name}=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;`;
}

// Function to delete all recent searches
function allDeleteCookie() {
    deleteCookie('recentSearches');
    updateRecentSearchList([]);
}

// Load the recent searches when the page loads
window.onload = function () {
    const recentSearches = getCookie('recentSearches') ? JSON.parse(getCookie('recentSearches')) : [];
    updateRecentSearchList(recentSearches);
};

// Function to update the recent search list in the HTML
function updateRecentSearchList(recentSearches) {
    const recentSearchList = document.getElementById('recentSearchList');
    recentSearchList.innerHTML = ''; // Clear the existing list

    if (recentSearches.length === 0) {
        const listItem = document.createElement('li');
        listItem.textContent = '최근 검색어가 없습니다.';
        recentSearchList.appendChild(listItem);
    } else {
        recentSearches.forEach((search, index) => {
            const listItem = document.createElement('li');
            const link = document.createElement('a');
            link.href = `/shop/search_result.php?search_str=${encodeURIComponent(search)}&x=0&y=0`;
            link.innerHTML = `<p>${search}</p>`;
            listItem.appendChild(link);

            const deleteButton = document.createElement('a');
            deleteButton.className = 'del_btn';
            deleteButton.textContent = 'X';
            deleteButton.onclick = function () {
                deleteRecentSearch(index);
            };
            listItem.appendChild(deleteButton);
            recentSearchList.appendChild(listItem);
        });
    }
}




/*========================================================================================================*/

// 페이지가 스크롤될 때 실행되는 함수
window.addEventListener('scroll', function () {
    var scrollTop = window.pageYOffset || document.documentElement.scrollTop;
    var headerLogo = document.querySelector('.header_logo');
    var headerBottomNav = document.querySelector('.header_nav');

    if (scrollTop > 10) {
        headerLogo.style.opacity = '0';
        headerLogo.style.top = '0px';
        headerBottomNav.style.top = '0%'; // Make it stick to the top
        headerBottomNav.style.backgroundColor = '#000'; // Change background color to white
    } else {
        headerLogo.style.opacity = '1';
        headerLogo.style.top = '0%';
        headerBottomNav.style.top = '0px'; // Adjust this value as needed
        headerBottomNav.style.backgroundColor = 'rgba(0,0,0,0.3)'; // Reset to default background color
    }
});


/*========================================================================================================*/

// // 페이지가 스크롤될 때 실행되는 함수
window.addEventListener('scroll', function () {
    var scrollTop = window.pageYOffset || document.documentElement.scrollTop;
    var headerLogo = document.querySelector('.header_logo');
    var headerBottomNav = document.querySelector('.header_bottom_nav');

    if (scrollTop > 1) {
        headerLogo.style.opacity = '0';
        headerLogo.style.top = '-10px';
        headerBottomNav.style.top = '35%'; // Make it stick to the top
        headerBottomNav.style.backgroundColor = 'white'; // Change background color to white
    } else {
        headerLogo.style.opacity = '1';
        headerLogo.style.top = '35%';
        headerBottomNav.style.top = '150px'; // Adjust this value as needed
        headerBottomNav.style.backgroundColor = ''; // Reset to default background color
    }
});

/*========================================================================================================*/

function cateHover(className) {
    var element = document.querySelector('.' + className);
    element.classList.add('visible');
}

function cateOut() {
    var element = document.querySelector('.cate_box_child0');
    element.classList.remove('visible');
    var element = document.querySelector('.cate_box_child1');
    element.classList.remove('visible');
    var element = document.querySelector('.cate_box_child2');
    element.classList.remove('visible');
    var element = document.querySelector('.cate_box_child3');
    element.classList.remove('visible');
    var element = document.querySelector('.cate_box_child4');
    element.classList.remove('visible');
    var element = document.querySelector('.cate_box_child5');
    element.classList.remove('visible');
    var element = document.querySelector('.cate_box_child6');
    element.classList.remove('visible');
    var element = document.querySelector('.cate_box_child7');
    element.classList.remove('visible');
    var element = document.querySelector('.cate_box_child8');
    element.classList.remove('visible');
    var element = document.querySelector('.cate_box_child9');
    element.classList.remove('visible');
    var element = document.querySelector('.cate_box_child10');
    element.classList.remove('visible');
}

/*========================================================================================================*/

history.scrollRestoration = "manual";




/*==================================================================================================*/

const scrollContainer = document.querySelector("[data-scroll-content]");
const scrollIndicator = document.querySelector("[data-scroll-indicator]");

let scrollPosition = 0;
const scrollAmount = 400;
const verticalScrollSpeed = 100; // Adjust vertical scroll speed
const horizontalScrollSpeed = 105; // Adjust horizontal scroll speed
let autoScrollTimer;

function autoScroll() {
    scrollPosition += scrollAmount;
    scrollContainer.scrollTo({
        left: scrollPosition,
        behavior: 'false' // Apply smooth scrolling
    });

    if (scrollPosition >= scrollContainer.scrollWidth - scrollContainer.clientWidth) {
        scrollPosition = 0;
    }
    updateScrollIndicator();
}

function startAutoScroll() {
    autoScrollTimer = setInterval(autoScroll, 3000); // Run every 3 seconds
}

function stopAutoScroll() {
    clearInterval(autoScrollTimer);
}

// Page load: start automatic scrolling
startAutoScroll();

// Update scroll indicator function
function updateScrollIndicator() {
    const maxScrollLeft = scrollContainer.scrollWidth - scrollContainer.clientWidth;
    const scrollLeft = scrollContainer.scrollLeft;
    const scrollPercentage = (scrollLeft / maxScrollLeft) * 100;
    scrollIndicator.style.width = scrollPercentage + "%";

    // Map the scroll percentage to 75% of the indicator container
    const indicatorWidthPercentage = (scrollPercentage * 73) / 100;
    scrollIndicator.style.width = indicatorWidthPercentage + "%";
}

// 마우스 휠 이벤트 처리
scrollContainer.addEventListener('wheel', function (event) {
    const delta = Math.sign(event.deltaY);
    const maxScrollLeft = scrollContainer.scrollWidth - scrollContainer.clientWidth;

    if (scrollContainer.scrollLeft >= maxScrollLeft && delta > 0) {
        window.scrollBy({
            top: delta * verticalScrollSpeed,
            behavior: 'false'
        });
    } else if (scrollContainer.scrollLeft === 0 && delta < 0) {
        window.scrollBy({
            top: delta * verticalScrollSpeed,
            behavior: 'false'
        });
    } else {
        scrollContainer.scrollLeft += delta * horizontalScrollSpeed; // Adjust horizontal scroll speed
    }
    event.preventDefault();
    updateScrollIndicator();
});

// 스크롤 이벤트 발생 시 게이지 바 업데이트
scrollContainer.addEventListener('scroll', updateScrollIndicator);

function autoScroll() {
    const maxScrollLeft = scrollContainer.scrollWidth - scrollContainer.clientWidth;
    if (scrollContainer.scrollLeft >= maxScrollLeft) {
        scrollContainer.scrollTo({
            left: 0,
            behavior: 'smooth'
        });
    } else {
        scrollContainer.scrollBy({
            left: scrollAmount,
            behavior: 'smooth'
        });
    }
    updateScrollIndicator();
}


/*=======================================================================================*/

// 두 번째 슬라이드 영역
// 첫 번째 슬라이드 영역
const scrollContainer2 = document.querySelector("[data-scroll-content2]");
const scrollIndicator2 = document.querySelector("[data-scroll-indicator2]");
let scrollPosition2 = 0;
const scrollAmount2 = 400;
const verticalScrollSpeed2 = 100;
const horizontalScrollSpeed2 = 105;
let autoScrollTimer2;

function autoScroll2() {
    scrollPosition2 += scrollAmount2;
    scrollContainer2.scrollTo({
        left: scrollPosition2,
        behavior: 'false'
    });

    if (scrollPosition2 >= scrollContainer2.scrollWidth - scrollContainer2.clientWidth) {
        scrollPosition2 = 0;
        setTimeout(() => {
            scrollContainer2.scrollTo({
                left: 0,
                behavior: 'false'
            });
        }, 500); // Adjust the delay to ensure smooth transition
    }
    updateScrollIndicator2();
}

function startAutoScroll2() {
    autoScrollTimer2 = setInterval(autoScroll2, 3000);
}

function stopAutoScroll2() {
    clearInterval(autoScrollTimer2);
}

// Page load: start automatic scrolling
startAutoScroll2();

function updateScrollIndicator2() {
    const maxScrollLeft2 = scrollContainer2.scrollWidth - scrollContainer2.clientWidth;
    const scrollLeft2 = scrollContainer2.scrollLeft;
    const scrollPercentage2 = (scrollLeft2 / maxScrollLeft2) * 100;
    const indicatorWidthPercentage2 = (scrollPercentage2 * 73) / 100;
    scrollIndicator2.style.width = indicatorWidthPercentage2 + "%";
}

scrollContainer2.addEventListener('wheel', function (event) {
    const delta2 = Math.sign(event.deltaY);
    const maxScrollLeft2 = scrollContainer2.scrollWidth - scrollContainer2.clientWidth;

    if (scrollContainer2.scrollLeft >= maxScrollLeft2 && delta2 > 0) {
        window.scrollBy({
            top: delta2 * verticalScrollSpeed2,
            behavior: 'false'
        });
    } else if (scrollContainer2.scrollLeft === 0 && delta2 < 0) {
        window.scrollBy({
            top: delta2 * verticalScrollSpeed2,
            behavior: 'false'
        });
    } else {
        scrollContainer2.scrollLeft += delta2 * horizontalScrollSpeed2;
    }
    event.preventDefault();
    updateScrollIndicator2();
});

scrollContainer2.addEventListener('scroll', updateScrollIndicator2);

function autoScroll2() {
    const maxScrollLeft2 = scrollContainer2.scrollWidth - scrollContainer2.clientWidth;
    if (scrollContainer2.scrollLeft >= maxScrollLeft2) {
        scrollContainer2.scrollTo({
            left: 0,
            behavior: 'smooth'
        });
    } else {
        scrollContainer2.scrollBy({
            left: scrollAmount2,
            behavior: 'smooth'
        });
    }
    updateScrollIndicator2();
}


// Function to delete a recent search by index
function deleteRecentSearch(index) {
    const recentSearches = getCookie('recentSearches') ? JSON.parse(getCookie('recentSearches')) : [];
    recentSearches.splice(index, 1); // Remove the search at the specified index
    setCookie('recentSearches', JSON.stringify(recentSearches)); // Update the cookie
    updateRecentSearchList(recentSearches); // Update the recent search list
}

// Function to delete all recent searches
function allDeleteCookie() {
    deleteCookie('recentSearches');
    updateRecentSearchList([]);
}

// Load the recent searches when the page loads
window.onload = function () {
    const recentSearches = getCookie('recentSearches') ? JSON.parse(getCookie('recentSearches')) : [];
    updateRecentSearchList(recentSearches);
};

var modal = document.getElementById("myModal");
var btn = document.getElementById("myBtn");
var span = document.getElementsByClassName("close")[0];

var headerLogo = document.querySelector('.header_logo');
var headerBottomNav = document.querySelector('.header_bottom_nav');
var loginJoinLink = btn.parentElement;

// 스크롤 이벤트 핸들러
function handleScroll() {
    var scrollTop = window.pageYOffset || document.documentElement.scrollTop;

    if (scrollTop > 1) {
        headerLogo.style.opacity = '0';
        headerLogo.style.top = '-10px';
        headerBottomNav.style.top = '35%';
        headerBottomNav.style.backgroundColor = 'white';
    } else {
        headerLogo.style.opacity = '1';
        headerLogo.style.top = '35%';
        headerBottomNav.style.top = '150px';
        headerBottomNav.style.backgroundColor = '';
    }
}

btn.onclick = function () {
    modal.style.display = "block";
    // 페이지 스크롤 비활성화
    document.body.style.overflow = "hidden";
    document.documentElement.style.overflow = "hidden";
    document.body.style.position = "fixed";
    document.body.style.width = "100%";
    document.body.style.top = `-${window.scrollY}px`;

    // 로고와 네비게이션 숨기기
    headerLogo.style.display = 'none';
    headerBottomNav.style.top = '35%';
    headerBottomNav.style.backgroundColor = 'white';

    // 로그인/가입 링크 숨기기
    loginJoinLink.style.display = 'none';

    // 스크롤 이벤트 리스너 비활성화
    window.removeEventListener('scroll', handleScroll);
}

span.onclick = function () {
    modal.style.display = "none";
    // 페이지 스크롤 활성화
    document.body.style.overflow = "";
    document.documentElement.style.overflow = "";
    document.body.style.position = "";
    document.body.style.width = "";
    document.body.style.top = "";

    // 로고와 네비게이션 원래대로
    headerLogo.style.display = '';
    headerBottomNav.style.top = '150px';
    headerBottomNav.style.backgroundColor = '';

    loginJoinLink.style.display = '';

    window.addEventListener('scroll', handleScroll);
}

window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
        // 페이지 스크롤 활성화
        document.body.style.overflow = "";
        document.documentElement.style.overflow = "";
        document.body.style.position = "";
        document.body.style.width = "";
        document.body.style.top = "";

        // 로고와 네비게이션 원래대로
        headerLogo.style.display = '';
        headerBottomNav.style.top = '150px';
        headerBottomNav.style.backgroundColor = '';

        // 로그인/가입 링크 다시 보이게 하기
        loginJoinLink.style.display = '';

        window.addEventListener('scroll', handleScroll);
    }
}

// 스크롤 이벤트 리스너 추가
window.addEventListener('scroll', handleScroll);


function validateEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(String(email).toLowerCase());
}

document.getElementById('email').addEventListener('input', function () {
    const email = this.value;
    const emailError = document.getElementById('emailError');
    const emailSuccess = document.getElementById('emailSuccess');

    if (email.trim() === '') {
        emailError.style.display = 'block';
        emailSuccess.style.display = 'none';
    } else if (validateEmail(email)) {
        emailSuccess.style.display = 'block';
        emailError.style.display = 'none';
    } else {
        emailError.style.display = 'block';
        emailSuccess.style.display = 'none';
    }
});

document.getElementById('password').addEventListener('input', function () {
    const passwordError = document.getElementById('passwordError');
    if (this.value.trim() !== '') {
        passwordError.style.display = 'none';
    }
});

document.getElementById('password').addEventListener('focus', function () {
    const emailSuccess = document.getElementById('emailSuccess');
    emailSuccess.style.display = 'none';
});

document.getElementById('loginForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const email = document.getElementById('email');
    const password = document.getElementById('password');
    const emailError = document.getElementById('emailError');
    const passwordError = document.getElementById('passwordError');
    const emailSuccess = document.getElementById('emailSuccess');

    let valid = true;

    if (email.value.trim() === '') {
        emailError.style.display = 'block';
        emailSuccess.style.display = 'none';
        valid = false;
    }

    if (password.value.trim() === '') {
        passwordError.style.display = 'block';
        valid = false;
    }

    if (valid) {
        alert('로그인 성공!');
        // 입력 필드 초기화
        email.value = '';
        password.value = '';
        emailError.style.display = 'none';
        passwordError.style.display = 'none';
        emailSuccess.style.display = 'none';
    }
});

const openPasswordModalBtn = document.getElementById('openPasswordModalBtn');
const passwordModal = document.getElementById('passwordModal');
const closePasswordModalBtn = passwordModal.querySelector('.close');

openPasswordModalBtn.addEventListener('click', function () {
    passwordModal.style.display = 'block';
});

closePasswordModalBtn.addEventListener('click', function () {
    passwordModal.style.display = 'none';
});

window.addEventListener('click', function (event) {
    if (event.target === passwordModal) {
        passwordModal.style.display = 'none';
    }
});

// 비밀번호 찾기 버튼 클릭 시 동작하는 함수
const findPasswordBtn = document.getElementById('findPasswordBtn');
findPasswordBtn.addEventListener('click', function () {
    // 비밀번호 찾기 동작 추가
    // 비밀번호를 찾은 후 모달 닫기
    passwordModal.style.display = 'none';
});
// 모달 창 표시를 위한 JavaScript 코드
const openModalBtn = document.getElementById('openModalBtn');
const idModal = document.getElementById('idModal');
const closeModalBtn = idModal.querySelector('.close');

openModalBtn.addEventListener('click', function () {
    idModal.style.display = 'block';
});

closeModalBtn.addEventListener('click', function () {
    idModal.style.display = 'none';
});

window.addEventListener('click', function (event) {
    if (event.target === idModal) {
        idModal.style.display = 'none';
    }
});

// 아이디 찾기 버튼 클릭 시 동작하는 함수
const findIdBtn = document.getElementById('findIdBtn');
findIdBtn.addEventListener('click', function () {
    const email = document.getElementById('email').value;
    // 여기에 아이디를 찾는 동작을 추가하세요 (예: 서버와 통신하여 이메일에 해당하는 아이디를 가져옴)
    alert(`입력하신 이메일(${email})로 등록된 아이디는 '사용자 아이디'입니다.`);
    idModal.style.display = 'none'; // 모달 닫기
});
document.querySelector('.custom-checkbox-label input[type="checkbox"]').addEventListener('change', function () {
    const checkbox = this;
    const checkboxContainer = checkbox.parentElement.querySelector('.custom-checkbox');
    checkboxContainer.classList.toggle('checked', checkbox.checked);
});
function poenCenjteredPopup(url, name, width, height) {
    const left = (window.screen.width - width) / 2;
    const top = (window.screen.height - height) / 2;
    const options = `width=${width}, height=${height}, left=${left}, top=${top}`;
    window.open(url, name, options);
}