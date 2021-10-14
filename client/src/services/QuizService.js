import axios from 'axios';

const QUIZ_REST_API_URL = 'http://localhost:8080/quizes';

class QuizService {
	getQuizes() {
		axios.get(QUIZ_REST_API_URL);
	}
}

export default new QuizService();
