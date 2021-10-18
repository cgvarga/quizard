import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';

const Footer = () => {
	return (
		<Container>
			<Row>
				<Col className='text-center footer'>Copyright &copy; 2021 Quizard</Col>
			</Row>
		</Container>
	);
};

export default Footer;
