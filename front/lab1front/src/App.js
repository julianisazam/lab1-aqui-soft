import React, { useState, useEffect } from 'react';
import axios from 'axios';
import FlightSearchForm from './Components/FlightSearchForm.js';
function App() {
  
  const [data, setData] = useState(null);

  useEffect(() => {
    axios.get('http://localhost:8080/api/flights/search?startDate=2024-09-01&endDate=2024-09-30&maxPrice=500&destination=London&origin=New York')
      .then(response => {
        console.log(data)
        setData(response.data);
      })
      .catch(error => {
        console.error('Error fetching data: ', error);
      });
  }, []);


  return (
      <div className="App">
      <FlightSearchForm />
    </div>
  );
}

export default App;
