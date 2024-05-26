<template>
  <div>
    <CustomTable
      :tableData="data"
      :columns="columns"
      :pagination="pagination"
      @sort-change="handleSortChange"
      @page-change="handlePageChange"
      @edit="handleEdit"
      @delete="handleDelete"
    />
  </div>
</template>

<script setup>
import { ref, watch } from 'vue';
import CustomTable from '@/components/CustomTable.vue';
import { useRoute, useRouter } from 'vue-router';

// 创建示例数据
const data = ref(
  Array.from({ length: 100 }).map((_, i) => ({
    date: `2022-05-${String(i + 1).padStart(2, '0')}`,
    name: `Name ${i + 1}`,
    state: 'California',
    city: 'San Francisco',
    address: '3650 21st St, San Francisco',
    zip: 'CA 94114',
    family: [
      {
        name: 'Jerry',
        state: 'California',
        city: 'San Francisco',
        address: '3650 21st St, San Francisco',
        zip: 'CA 94114',
      },
      {
        name: 'Spike',
        state: 'California',
        city: 'San Francisco',
        address: '3650 21st St, San Francisco',
        zip: 'CA 94114',
      },
      {
        name: 'Tyke',
        state: 'California',
        city: 'San Francisco',
        address: '3650 21st St, San Francisco',
        zip: 'CA 94114',
      },
    ],
  }))
);

const columns = ref([
  { prop: 'date', label: 'Date', sortable: true, slot: 'date' },
  { prop: 'name', label: 'Name', sortable: false, slot: 'name' },
  { prop: 'address', label: 'Address', sortable: false, slot: 'address' },
]);

const pagination = ref({
  currentPage: 1,
  pageSize: 10,
  total: data.value.length,
});

const handleSortChange = ({ prop, order }) => {
  console.log('Sort change:', prop, order);
  // 处理排序逻辑
};

const handlePageChange = (page) => {
  pagination.value.currentPage = page;
  console.log('Page change:', page);
  // 处理分页逻辑
};

const handleEdit = (row) => {
  console.log('Edit row:', row);
  // 处理编辑逻辑
};

const handleDelete = (row) => {
  console.log('Delete row:', row);
  // 处理删除逻辑
};

const route = useRoute();
const router = useRouter();
const query = route.query;

watch(query, () => {
  if (query.name || query.address || query.date) {
    // 在这里处理搜索查询
    data.value = data.value.filter((item) => {
      return (
        (!query.name || item.name.includes(query.name)) &&
        (!query.address || item.address.includes(query.address)) &&
        (!query.date || item.date.includes(query.date))
      );
    });
  } else {
    // 如果没有查询参数，重置数据
    data.value = Array.from({ length: 100 }).map((_, i) => ({
      date: `2022-05-${String(i + 1).padStart(2, '0')}`,
      name: `Name ${i + 1}`,
      state: 'California',
      city: 'San Francisco',
      address: '3650 21st St, San Francisco',
      zip: 'CA 94114',
      family: [
        {
          name: 'Jerry',
          state: 'California',
          city: 'San Francisco',
          address: '3650 21st St, San Francisco',
          zip: 'CA 94114',
        },
        {
          name: 'Spike',
          state: 'California',
          city: 'San Francisco',
          address: '3650 21st St, San Francisco',
          zip: 'CA 94114',
        },
        {
          name: 'Tyke',
          state: 'California',
          city: 'San Francisco',
          address: '3650 21st St, San Francisco',
          zip: 'CA 94114',
        },
      ],
    }));
  }
}, { immediate: true });

</script>

