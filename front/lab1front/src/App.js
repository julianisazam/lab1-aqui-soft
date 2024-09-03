import React, { useState, useEffect } from 'react';
import axios from 'axios';

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
    <div>
      <h1>Data from API:</h1>
      {data ? (
        <pre>{JSON.stringify(data, null, 2)}</pre>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
}

export default App;
