// backendServiceSearch.js
const API_BASE_URL = 'http://localhost:8080';

const backendServiceSearch = {
    advancedSearch: async (searchCriteria) => {
        try {
            const response = await fetch(`${API_BASE_URL}/search`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(searchCriteria),
            });

            const data = await response.json();
            return data;
        } catch (error) {
            console.error('Error performing advanced search:', error);
            throw error;
        }
    },
};

export default backendServiceSearch;