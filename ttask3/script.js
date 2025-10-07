// Sample data (could be from API or gist link)
const data = [];
for (let i = 1; i <= 100; i++) {
  data.push(`Item ${i}`);
}

const itemsPerPage = 10;
let currentPage = 1;

function displayData(page) {
  const dataContainer = document.getElementById("data-container");
  dataContainer.innerHTML = "";

  let start = (page - 1) * itemsPerPage;
  let end = start + itemsPerPage;
  let paginatedItems = data.slice(start, end);

  paginatedItems.forEach(item => {
    let div = document.createElement("div");
    div.classList.add("item");
    div.textContent = item;
    dataContainer.appendChild(div);
  });
}

function setupPagination() {
  const pagination = document.getElementById("pagination");
  pagination.innerHTML = "";

  let pageCount = Math.ceil(data.length / itemsPerPage);

  // Prev button
  let prevBtn = document.createElement("button");
  prevBtn.textContent = "Prev";
  prevBtn.disabled = currentPage === 1;
  prevBtn.addEventListener("click", () => {
    if (currentPage > 1) {
      currentPage--;
      displayData(currentPage);
      setupPagination();
    }
  });
  pagination.appendChild(prevBtn);

  // Page numbers
  for (let i = 1; i <= pageCount; i++) {
    let btn = document.createElement("button");
    btn.textContent = i;
    if (i === currentPage) btn.classList.add("active");
    btn.addEventListener("click", () => {
      currentPage = i;
      displayData(currentPage);
      setupPagination();
    });
    pagination.appendChild(btn);
  }

  // Next button
  let nextBtn = document.createElement("button");
  nextBtn.textContent = "Next";
  nextBtn.disabled = currentPage === pageCount;
  nextBtn.addEventListener("click", () => {
    if (currentPage < pageCount) {
      currentPage++;
      displayData(currentPage);
      setupPagination();
    }
  });
  pagination.appendChild(nextBtn);
}

// Initialize
displayData(currentPage);
setupPagination();
