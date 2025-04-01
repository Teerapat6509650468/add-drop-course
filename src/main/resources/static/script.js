// API endpoint
const API_URL = '/api/course-requests';

// Load course requests when the page loads
document.addEventListener('DOMContentLoaded', () => {
    loadCourseRequests();
});

// Function to add a new subject form
function addSubject(type) {
    const container = document.getElementById(`${type}SubjectList`);
    const subjectCount = container.children.length;

    if (subjectCount >= 10) {
        alert(`ไม่สามารถเพิ่มรายวิชาได้เกิน 10 รายวิชาใน${type === 'add' ? 'การเพิ่ม' : 'การถอน'}`);
        return;
    }

    const subjectForm = document.createElement('div');
    subjectForm.className = 'subject-form';
    subjectForm.innerHTML = `
        <div class="form-group">
            <label>รหัสรายวิชา:</label>
            <input type="text" required>
        </div>
        <div class="form-group">
            <label>ชื่อรายวิชา:</label>
            <input type="text" required>
        </div>
        <div class="form-group">
            <label>ตอนเรียน:</label>
            <input type="text" required>
        </div>
        <div class="form-group">
            <label>วัน/เวลา:</label>
            <input type="text" required>
        </div>
        <div class="form-group">
            <label>หน่วยกิต:</label>
            <input type="text" required>
        </div>
        <div class="form-group">
            <label>อาจารย์ผู้สอน:</label>
            <input type="text" required>
        </div>
        <div class="form-group">
            <label>
                <input type="checkbox"> ตรวจสอบโดยอาจารย์
            </label>
        </div>
        <button type="button" onclick="this.parentElement.remove()">ลบรายวิชา</button>
    `;

    container.appendChild(subjectForm);
}

// Function to collect subject data
function collectSubjects(containerId) {
    const container = document.getElementById(containerId);
    const subjects = [];
    
    container.querySelectorAll('.subject-form').forEach(form => {
        const inputs = form.querySelectorAll('input');
        subjects.push({
            subjectCode: inputs[0].value,
            subjectName: inputs[1].value,
            subjectSection: inputs[2].value,
            subjectDate: inputs[3].value,
            subjectCredit: inputs[4].value,
            subjectTeacher: inputs[5].value,
            subjectTeacherCheck: inputs[6].checked
        });
    });

    return subjects;
}

// Function to validate the form
function validateForm() {
    const addSubjects = document.getElementById('addSubjectList').children.length;
    const dropSubjects = document.getElementById('dropSubjectList').children.length;

    if (addSubjects === 0 && dropSubjects === 0) {
        alert('กรุณาเพิ่มรายวิชาที่ต้องการเพิ่มหรือถอนอย่างน้อย 1 รายวิชา');
        return false;
    }

    return true;
}

// Function to submit the form
document.getElementById('courseRequestForm').addEventListener('submit', async (e) => {
    e.preventDefault();

    if (!validateForm()) {
        return;
    }

    const formData = {
        date: document.getElementById('date').value,
        studentFirstName: document.getElementById('studentFirstName').value,
        studentLastName: document.getElementById('studentLastName').value,
        studentId: document.getElementById('studentId').value,
        studentYear: parseInt(document.getElementById('studentYear').value),
        studyField: document.getElementById('studyField').value,
        advisor: document.getElementById('advisor').value,
        addressNumber: document.getElementById('addressNumber').value,
        moo: document.getElementById('moo').value,
        tumbol: document.getElementById('tumbol').value,
        amphur: document.getElementById('amphur').value,
        province: document.getElementById('province').value,
        postalCode: document.getElementById('postalCode').value,
        mobilePhone: document.getElementById('mobilePhone').value,
        phone: document.getElementById('phone').value || null,
        cause: document.getElementById('cause').value,
        addSubjectList: collectSubjects('addSubjectList'),
        dropSubjectList: collectSubjects('dropSubjectList')
    };

    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        });

        if (response.ok) {
            alert('ส่งคำขอเพิ่มถอนรายวิชาสำเร็จ');
            document.getElementById('courseRequestForm').reset();
            loadCourseRequests();
        } else {
            const error = await response.json();
            alert(`เกิดข้อผิดพลาด: ${error.message || 'ไม่สามารถส่งคำขอได้'}`);
        }
    } catch (error) {
        alert('เกิดข้อผิดพลาดในการส่งคำขอ: ' + error.message);
    }
});

// Function to load course requests
async function loadCourseRequests() {
    try {
        console.log('Fetching course requests from:', API_URL);
        const response = await fetch(API_URL);
        console.log('Response status:', response.status);
        
        if (!response.ok) {
            const errorText = await response.text();
            console.error('Error response:', errorText);
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        
        const requests = await response.json();
        console.log('Received requests:', requests);
        
        const requestsList = document.getElementById('requestsList');
        requestsList.innerHTML = '';

        if (!requests || requests.length === 0) {
            requestsList.innerHTML = '<p>ไม่มีรายการคำขอเพิ่มถอนรายวิชา</p>';
            return;
        }

        requests.forEach(request => {
            const requestCard = document.createElement('div');
            requestCard.className = 'request-card';
            
            requestCard.innerHTML = `
                <h3>คำขอ #${request.id}</h3>
                <div class="request-info">
                    <p><strong>วันที่:</strong> ${request.date}</p>
                    <p><strong>นักศึกษา:</strong> ${request.studentFirstName} ${request.studentLastName}</p>
                    <p><strong>รหัสนักศึกษา:</strong> ${request.studentId}</p>
                    <p><strong>ชั้นปี:</strong> ${request.studentYear}</p>
                    <p><strong>สาขาวิชา:</strong> ${request.studyField}</p>
                    <p><strong>อาจารย์ที่ปรึกษา:</strong> ${request.advisor}</p>
                    <p><strong>เหตุผล:</strong> ${request.cause}</p>
                </div>
                <div class="subjects-list">
                    ${request.addSubjectList && request.addSubjectList.length > 0 ? `
                        <h4>รายวิชาที่เพิ่ม:</h4>
                        <ul>
                            ${request.addSubjectList.map(subject => `
                                <li>${subject.subjectCode} - ${subject.subjectName} (${subject.subjectSection})</li>
                            `).join('')}
                        </ul>
                    ` : ''}
                    ${request.dropSubjectList && request.dropSubjectList.length > 0 ? `
                        <h4>รายวิชาที่ถอน:</h4>
                        <ul>
                            ${request.dropSubjectList.map(subject => `
                                <li>${subject.subjectCode} - ${subject.subjectName} (${subject.subjectSection})</li>
                            `).join('')}
                        </ul>
                    ` : ''}
                </div>
                <button onclick="deleteRequest(${request.id})">ลบคำขอ</button>
            `;

            requestsList.appendChild(requestCard);
        });
    } catch (error) {
        console.error('เกิดข้อผิดพลาดในการโหลดคำขอ:', error);
        const requestsList = document.getElementById('requestsList');
        requestsList.innerHTML = `<p class="error">เกิดข้อผิดพลาดในการโหลดคำขอ: ${error.message}</p>`;
    }
}

// Function to delete a course request
async function deleteRequest(id) {
    if (!confirm('คุณแน่ใจหรือไม่ที่จะลบคำขอนี้?')) {
        return;
    }

    try {
        const response = await fetch(`${API_URL}/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            alert('ลบคำขอสำเร็จ');
            loadCourseRequests();
        } else {
            alert('ไม่สามารถลบคำขอได้');
        }
    } catch (error) {
        console.error('เกิดข้อผิดพลาดในการลบคำขอ:', error);
        alert('เกิดข้อผิดพลาดในการลบคำขอ');
    }
} 