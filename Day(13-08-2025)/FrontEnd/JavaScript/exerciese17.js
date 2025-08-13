const quiz = [
            {
                question: "What is my name?",
                options: ["vedanti", "Mumbai", "john", "alice"],
                answer: "vedanti"
            },
            {
                question: "Which animal I like?",
                options: ["dog", "parrot", "cat", "snake"],
                answer: "cat"
            },
            {
                question: "Who I am'?",
                options: ["Software developer", "civil engineer", "influencer", "manager"],
                answer: "Software developer"
            }
        ];

        let currentQuestion = 0;
        let score = 0;

        const questionEl = document.getElementById("question");
        const optionsEl = document.getElementById("options");
        const feedbackEl = document.getElementById("feedback");
        const scoreEl = document.getElementById("score");

        function loadQuestion() {
            feedbackEl.textContent = "";
            const q = quiz[currentQuestion];
            questionEl.textContent = q.question;
            optionsEl.innerHTML = "";

            q.options.forEach(option => {
                const btn = document.createElement("button");
                btn.textContent = option;
                btn.className = "option";
                btn.onclick = () => checkAnswer(option);
                optionsEl.appendChild(btn);
            });
        }

        function checkAnswer(selected) {
            const correct = quiz[currentQuestion].answer;
            if (selected === correct) {
                feedbackEl.textContent = "Correct!";
                score++;
            } else {
                feedbackEl.textContent = "Wrong!";
            }
            scoreEl.textContent = "Score: " + score;
        }

        function nextQuestion() {
            currentQuestion++;
            if (currentQuestion >= quiz.length) {
                questionEl.textContent = "Quiz Finished!";
                optionsEl.innerHTML = "";
                feedbackEl.textContent = "Your final score: " + score;
            } else {
                loadQuestion();
            }
        }

        loadQuestion();