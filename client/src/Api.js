import axios from 'axios'

const SERVER_URL = 'http://localhost:8088';

const instance = axios.create({
    baseURL: SERVER_URL,
    timeout: 1000
});

export default {
    // (C)reate
    createNew: (text, completed) => instance.post('todos', {title: text, completed: completed}),
    // (R)ead
    getAll: () => instance.get('todos', {
        transformResponse: [function (data) {
            return data? JSON.parse(data) : data;
        }]
    }),
    // (U)pdate
    updateForId: (id, text, completed) => instance.put('todos/'+id, {title: text, completed: completed}),
    // (D)elete
    removeForId: (id) => instance.delete('todos/'+id)
}