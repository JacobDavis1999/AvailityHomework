import React from 'react'

const Header = ({toggleForm}) => {
    return(
    <header>
        <div className="container">
            <h1>Sign up to Availity!</h1>
            <button onClick={toggleForm}>Sign Up</button>
        </div>
    </header>
    );
};

export default Header;