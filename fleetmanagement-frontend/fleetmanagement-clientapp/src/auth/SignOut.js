import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

function SignOut({isAuthenticated, setIsAuthenticated}) {
	const navigate = useNavigate(); // Use useNavigate instead of useHistory

	useEffect(() => {

		// Remove token and name from sessionStorage
		sessionStorage.removeItem('token');
		sessionStorage.removeItem('name');

		// Set isAuthenticated to false
		setIsAuthenticated(false);

		// Navigate to the home page ("/")
	    navigate('/'); // Use navigate to programmatically navigate
  }, [navigate, setIsAuthenticated])

	return (
		<div className="text-center">
			<h1>Successfully sign out</h1>
		</div>
	)
}

export default SignOut;