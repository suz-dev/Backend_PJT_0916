<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- 부트 -->
</head>

<body>
	<%@ include file="include/header.jsp"%>
	<img src="./img/back.PNG" width="100%" height="200px">

	<div class="container-lg themed-container">

		<section>
			<!--흠-->
			<nav class="navbar navbar-light bg-light">
				<div class="container-fluid">
					<form class="d-flex flex-row bd-highlight mb-3">
						<input class="form-control me-2" type="search"
							placeholder="운동을 검색하세요" aria-label="Search">
						<button class="btn btn-outline-primary" type="submit">Search</button>
					</form>
				</div>
			</nav>


			<article style="margin: 0px; padding: 0px;">
				<div class="title" style="font-size: x-large;">최근 가장 많이 본 동영상</div>
				<div class="swiper">

					<!-- Additional required wrapper -->
					<div class="swiper-wrapper">
						<!-- Slides -->
						<div class="swiper-slide">

							<ul id="video-list" width="100%">
								<c:forEach var="video" items="${videoList}">
									<div class="d-inline-flex flex-nowrap">
										<span class="card" style="width: 18rem;">
											<a href="video?action=detail&id=${video.id}"> <img
												class="card-img-top" src="./img/thumbnail${video.id}.jpg"
												alt="Card image cap">
											</a>
											<div class="card-body">
												<p class="card-text">
												<div class="card-upper">
													<div class="summary">${video.title}</div>
													<div class="viewCnt">${video.viewCnt}</div>
												</div>
												</p>
												<div class="btns">
													<div class="part">${video.part}</div>
												</div>
											</div>
										</span>
									</div>

								</c:forEach>
							</ul>

						</div>
					</div>
					<!-- If we need navigation buttons -->
					<div class="swiper-button-prev"></div>
					<div class="swiper-button-next"></div>
				</div>

			</article>


			<article style="margin: 0px; padding: 0px;">
				<div>
					<div class="title" style="font-size: x-large;">운동 부위 선택</div>
					<button id="enBodyBtn" class="btn" type="submit">전신</button>
					<button id="upBodyBtn" class="btn" type="submit">상체</button>
					<button id="loBodyBtn" class="btn" type="submit">하체</button>
					<button id="abMuscleBtn" class="btn" type="submit">복부</button>
				</div>

				<fieldset>
					<ul id="part-list"
						style="margin: 10px 20px; padding: 0px; display: flex; justify-content: space-between;">
						<!-- 부위별 운동영상 출력 -->
						<c:forEach var="video" items="${partList}">
							<div class="card" style="width: 18rem;">
								<a href="video?action=detail&id=${video.id}"> <img
									class="card-img-top" src="img/thumbnail${video.id}.jpg"
									alt="Card image cap">
								</a>
								<div class="card-body">
									<p class="card-text">
									<div class="card-upper">
										<div class="summary">${video.title}</div>
										<div class="viewCnt">${video.viewCnt}</div>
									</div>
									</p>
									<div class="btns">
										<div class="part">${video.part}</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</ul>
				</fieldset>
			</article>
		</section>

	</div>


	<footer>
		<!-- 푸터 -->
	</footer>

	<!-- 자바스크립트 cdn -->
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css" />

	<script
		src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
	<script>
    const swiper = new Swiper('.swiper', {
      loop: true,
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
      slidesPerView: 1,
      slidesPerGroup: 1,
    });
  </script>

	<!-- 자바스크립트 구현 -->
	<script>
    const videoList = []
    const enBodyList = []
    const upBodyList = []
    const loBodyList = []
    const abMuscleList = []
    const enBodyBtn = document.querySelector('#enBodyBtn');
    const upBodyBtn = document.querySelector('#upBodyBtn');
    const loBodyBtn = document.querySelector('#loBodyBtn');
    const abMuscleBtn = document.querySelector('#abMuscleBtn');

    //초기화면 
    window.addEventListener("load", () => {

      const URL = "/data/video.json";
      const promise = axios.get(URL)

      promise
        .then((res) => {
          console.log("응답성공")
          return res.data
        })
        .then((res) => {
          res.forEach(ele => {
            const video = {
              id: ele.id,
              title: ele.title,
              part: ele.part,
              url: ele.url,
            }
            videoList.push(video)
          })
          return videoList
        })
        .then((res) => {
          let ulTag = document.querySelector("#video-list")
          res.forEach(ele => {

            let idText = JSON.stringify(ele.id).replace(/\"/gi, "")

            let div = document.createElement("div");
            let img = document.createElement("img");
            let title = document.createElement("a");
            let part = document.createElement("span");
            let br1 = document.createElement("br");
            let br2 = document.createElement("br");

            div.setAttribute("style", "margin : 3px 10px;")
            // part.setAttribute("style", "color : blue; background-color : green")
            part.setAttribute("style", "display:inline-block; margin:10px; padding:5px;  color:white; font-weight:bold; background:cornflowerBlue;")

            img.setAttribute("src", `https://img.youtube.com/vi/${idText}/mqdefault.jpg`)

            title.innerText = ele.title
            title.setAttribute("style", "display : block; width : 320px;")
            title.addEventListener("click", () => {
              localStorage.setItem("video", JSON.stringify(ele))
              alert("영상화면으로 이동합니다")
            })
            title.setAttribute("href", "review.html")
            part.innerText = ele.part

            let partVal = JSON.stringify(ele.part).replace(/\"/gi, "")
            if (partVal == "전신") {
              part.setAttribute("style", "display:inline-block; margin:10px; padding:5px;  color:white; font-weight:bold; background:cornflowerBlue;")
            } else if (partVal == "상체") {
              part.setAttribute("style", "display:inline-block; margin:10px; padding:5px;  color:white; font-weight:bold; background:Brown;")
            } else if (partVal == "하체") {
              part.setAttribute("style", "display:inline-block; margin:10px; padding:5px;  color:white; font-weight:bold; background:green;")
            } else if (partVal == "복부") {
              part.setAttribute("style", "display:inline-block; margin:10px; padding:5px;  color:white; font-weight:bold; background:Coral;")
            }

            div.appendChild(img)
            div.appendChild(br1)
            div.appendChild(title)
            div.appendChild(br2)
            div.appendChild(part)
            ulTag.appendChild(div)

          })
          return res
        })
        .then((res) => {
          res.forEach(ele => {

            let part = JSON.stringify(ele.part).replace(/\"/gi, "")
            if (part == "전신") {
              enBodyList.push(ele)
            } else if (part == "상체") {
              upBodyList.push(ele)
            } else if (part == "하체") {
              loBodyList.push(ele)
            } else if (part == "복부") {
              abMuscleList.push(ele)
            }
          })
          return enBodyList
        })
        .then((res) => {
          let ulTag = document.querySelector("#part-list")

          res.forEach(ele => {
            let idText = JSON.stringify(ele.id).replace(/\"/gi, "")

            let div = document.createElement("div");
            let img = document.createElement("img");
            let title = document.createElement("a");
            let part = document.createElement("span");
            let br1 = document.createElement("br");
            let br2 = document.createElement("br");

            div.setAttribute("style", "margin : 3px;")
            // part.setAttribute("style", "color : blue; background-color : green")
            part.setAttribute("style", "display:inline-block; margin:10px; padding:5px;  color:white; font-weight:bold; background:cornflowerBlue;")

            img.setAttribute("src", `https://img.youtube.com/vi/${idText}/mqdefault.jpg`)
            title.innerText = ele.title
            title.addEventListener("click", () => {
              alert("영상화면으로 이동합니다")
            })
            title.setAttribute("href", "review.html")
            part.innerText = ele.part

            div.appendChild(img)
            div.appendChild(br1)
            div.appendChild(title)
            div.appendChild(br2)
            div.appendChild(part)
            ulTag.appendChild(div)
          })
        })

      //해당부위 화면출력
      const selectVideo = (list) => {
        console.log(list)
        let ulTag = document.querySelector("#part-list")

        removeAllchild(ulTag)

        list.forEach(ele => {

          console.log(ele.id)

          let div = document.createElement("div");
          let img = document.createElement("img");
          let title = document.createElement("a");
          let part = document.createElement("div");
          let br1 = document.createElement("br");
          let br2 = document.createElement("br");

          img.setAttribute("src", `https://img.youtube.com/vi/${ele.id}/mqdefault.jpg`)
          title.innerText = ele.title
          title.setAttribute("href", "review.html")
          part.innerText = ele.part

          let partVal = JSON.stringify(ele.part).replace(/\"/gi, "")
          if (partVal == "전신") {
            part.setAttribute("style", "display:inline-block; margin:10px; padding:5px;  color:white; font-weight:bold; background:cornflowerBlue;")
          } else if (partVal == "상체") {
            part.setAttribute("style", "display:inline-block; margin:10px; padding:5px;  color:white; font-weight:bold; background:Brown;")
          } else if (partVal == "하체") {
            part.setAttribute("style", "display:inline-block; margin:10px; padding:5px;  color:white; font-weight:bold; background:green;")
          } else if (partVal == "복부") {
            part.setAttribute("style", "display:inline-block; margin:10px; padding:5px;  color:white; font-weight:bold; background:Coral;")
          }

          div.appendChild(img)
          div.appendChild(br1)
          div.appendChild(title)
          div.appendChild(br2)
          div.appendChild(part)
          ulTag.appendChild(div)
        })
      }

      //기존의 파트내용 지우기 
      function removeAllchild(div) {
        while (div.hasChildNodes()) {
          div.removeChild(div.firstChild);
        }
      }

      //부위별 버튼 클릭
      enBodyBtn.addEventListener("click", () => {
        let list = enBodyList
        selectVideo(list)
      })
      upBodyBtn.addEventListener("click", () => {
        let list = upBodyList
        selectVideo(list)
      })
      loBodyBtn.addEventListener("click", () => {
        let list = loBodyList
        selectVideo(list)
      })
      abMuscleBtn.addEventListener("click", () => {
        let list = abMuscleList
        selectVideo(list)
      })


    })
  </script>

</body>

</html>