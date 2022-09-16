<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        input {
            width: 60%;
            height: 40%;
            margin: 5px;
        }

        textarea {
            width: 60%;
            height: 300px;
        }


        #cancelBtn {
            padding: 10px 20px;
            border: red 1px solid;
            color: red;
            background-color: white;
            width: 70px;
            padding: 5px;
        }

        #registBtn {
            padding: 10px 20px;
            border: rgb(14, 123, 247) 1px solid;
            color: rgb(14, 123, 247);
            background-color: white;
            width: 70px;
            padding: 5px;
        }

        #writeBtn {
            width: 70px;
            padding: 5px;
        }
    </style>
</head>

<body>
    <div class="container-lg themed-container text-center">
        <h1 style="margin-top: 5%;">운동영상 리뷰</h1>
        <hr>
        <div>
            <div>
                <input id="title" type="text" placeholder="제목">
                <textarea id="content" placeholder="내용"></textarea>
            </div>
        </div>
        <div>
            <button id="registBtn">등록</button>
            <button id="cancelBtn">취소</button>
        </div>
    </div>

    <!-- 자바스크립트 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>


    <script>
        const title = document.querySelector("#title")
        const content = document.querySelector("#content")
        const registBtn = document.querySelector("#registBtn")
        const cancelBtn = document.querySelector("#cancelBtn")

        //초기화면
        window.addEventListener("load", () => {
            const video = JSON.parse(localStorage.getItem("video"))
            const iframeTag = document.querySelector("#videoPlayer")
            iframeTag.setAttribute("src", video.url)

        })

        //리뷰 생성 및 등록
        const createRiview = (review) => {
            console.log(review)
        }

        //등록 버튼 클릭
        registBtn.addEventListener("click", () => {
            let review = {
                title: title.value,
                content: content.value,
            }
            createRiview(review)
            title.value = ""
            content.value = ""
            alert("리뷰가 등록되었습니다.")
            window.location.replace("review.html")
        })

        //취소버튼클릭
        cancelBtn.addEventListener("click", () => {
            window.location.replace("review.html")
        })

    </script>

</body>

</html>