import axios from 'axios';

const QUIZ_REST_API_URL = 'http://localhost:8080/quizes';

class QuizService {
	async getQuizes() {
		try {
			const data = await axios.get(QUIZ_REST_API_URL);
			return data;
		} catch (error) {
			console.error(error);
		}
	}
}

export default new QuizService();
