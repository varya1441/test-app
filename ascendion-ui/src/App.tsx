import {useState} from 'react'
import './App.css'

function App() {
    const [count, setCount] = useState(0);
    const [name, setName] = useState("")
    const [error, setError] = useState("")
    const [isLoading, setIsLoading] = useState(false)
    const [nameInputText, setNameInputText] = useState("")
    
    const handleNameChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const value = e.target.value;
        
        const hasSpecialCharsOrDigits = /[^a-zA-Z\s]/.test(value);
        
        if (hasSpecialCharsOrDigits) {
            setError("Name should only contain letters");
        } else if (value.length > 0 && value.length < 2) {
            setError("Name should be at least 2 characters long");
        } else {
            setError("");
        }
        
        setName(value);
    };
    
    const handleButtonClick = async () => {
        if (error !== "" || name.length < 2) {
            return;
        }
        
        setIsLoading(true);
        
        try {
            const response = await fetch('/api/click', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    count: count + 1,
                    name: name
                })
            });
            
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            
            const data = await response.json();
            console.log('Backend response:', data);
            setCount((prevCount) => prevCount + 1);
            setNameInputText(data.message);
        } catch (error) {
            console.error('Error sending data to backend:', error);
            alert('Failed to send data to backend. Please try again.');
        } finally {
            setIsLoading(false);
        }
    };
    
    return (
        <>
            <div className="card">
                <div className="title">
                    <h1>Enter you name</h1>
                </div>
                <input
                    type="text"
                    id="name"
                    placeholder="type your name..."
                    value={name}
                    onChange={handleNameChange}
                />
                {error && (
                    <div
                        className="error"
                        style={{
                            color: 'red',
                            fontSize: '14px',
                            marginTop: '5px'
                        }}
                    >
                        {error}
                    </div>
                )}
                <div style={{ marginTop: '10px' }}>
                    <button
                        onClick={handleButtonClick}
                        disabled={error !== "" || name.length < 2 || isLoading}
                        style={{
                            opacity:
                                error !== "" || name.length < 2 || isLoading
                                    ? 0.5
                                    : 1,
                            cursor:
                                error !== "" || name.length < 2 || isLoading
                                    ? 'not-allowed'
                                    : 'pointer'
                        }}
                    >
                        {isLoading ? 'Sending...' : 'Click me'}
                    </button>
                </div>
                <div style={{ marginTop: '10px' }}>{nameInputText}</div>
            </div>
        </>
    )
}

export default App
